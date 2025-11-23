package ProjekUAS;

import java.util.Scanner;

public class GameApp {
    private Scanner scanner;
    private UserAccount user;
    private MachineManager manajerMesin;

    public GameApp() {
        scanner = new Scanner(System.in);
        manajerMesin = new MachineManager();
    }

    public void start() {
        loginMenu();
    }

    private void loginMenu() {

        boolean cek = true;
        while (cek) { 
        user = new UserAccount("fuira", "123");

        System.out.println("=== LOGIN ===");
        System.out.print("Username: ");
        String usern = scanner.nextLine();
        System.out.print("Password: ");
        String pw = scanner.nextLine();

        boolean hasil = user.login(usern, pw);

            if (hasil == true) {
                System.out.println("Login Berhasil !\n");
                cek = false;
                mainMenu();
            } else {
                System.out.println("Password / Username Salah.\n");
            }
        }

    }

    private void mainMenu() {
        while (true) {
            
            System.out.print (
                "\n=== MENU UTAMA ===\n" +
                "1. Lihat Inventory\n" +
                "2. Tambah Coin\n" +
                "3. Cek Saldo Koin\n" +
                "4. Mulai Permainan\n" +
                "0. Exit\n" +
                "Pilih: "
            );

            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> showInventory();
                case 2 -> tambahCoin();
                case 3 -> cekSaldo();
                case 4 -> permainan();
                case 0 -> {
                    System.out.println("\nByee, Terima kasih sudah bermain !");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void showInventory() {
        System.out.println("\n=== INVENTORY ===");
        if (user.getInventory().getDolls().isEmpty()) {
            System.out.println("Inventory kosong!");
        } else {
            for (Doll d : user.getInventory().getDolls()) {
                System.out.println("- " + d.getNamaBoneka() + " (" + d.getRarity() + ")");
            }
        }
    }

    private void tambahCoin() {
        System.out.print (
        "\n=== TOP-UP ISI SALDO KOIN ===\n" +
        "Masukkan nominal koin: "
        );

        int nominal = scanner.nextInt();

        user.addCoins(nominal);
        System.out.println("Coin ditambah! Total coin: " + user.getCoins());
    }

    private void permainan() {
        System.out.println("\nAnda telah masuk di sesi permainan !" + "\nSilahkan pilih mesin:" );
        int i = 1;
        for (Mesin m : manajerMesin.getMachines()) {
            System.out.println(i + ". " + m.namaMesin + " (Chance: " + (m.successRate*100) + "%)");
            i++;
        }

        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        Mesin selected = manajerMesin.getMachines().get(pilihan - 1);

        System.out.println("\nMasukkan koin untuk bermain (harga: " + selected.hargaMain + "): ");
        if (user.getCoins() < selected.hargaMain) {
            System.out.println("Koin tidak cukup!");
            return;
        } 
        
        user.addCoins(-selected.hargaMain);

        Doll hasil = selected.play();
        if (hasil != null) {
            System.out.println("Selamat! Kamu mendapat: " + hasil.getNamaBoneka());
            user.getInventory().addDoll(hasil);
        } else {
            System.out.println("Gagal! Coba lagi ya");
        }

    }

    private void cekSaldo() {
        System.out.print("\n=== SALDO KOIN ===\n" +
            "Koin: " + user.getCoins() +
            "\nApakah anda ingin isi saldo koin? (Ya / Tidak)\n" +
            "Pilih: "
        );

        String pilihan = scanner.nextLine();

        if (pilihan.equalsIgnoreCase("Ya")) {
            tambahCoin();
        } else if (pilihan.equalsIgnoreCase("Tidak")) {
            mainMenu();
        }
        
    }

}
