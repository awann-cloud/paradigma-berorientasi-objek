package ProjekUAS;

import java.util.Scanner;

public class GameApp {
    private Scanner scanner;
    private Account user;
    private MachineManager manajerMesin;
    private AccountManager accountManager = new AccountManager();

    public GameApp() {
        scanner = new Scanner(System.in);
        manajerMesin = new MachineManager();
    }

    public void start() {
        autentikasiMenu();
    }
    
    public void register() {
        if (scanner.hasNextLine()) scanner.nextLine();

        System.out.println("\n=== REGISTRASI ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String pw = scanner.nextLine();

        accountManager.register(username, pw);
    }

    public void login() {
        if (scanner.hasNextLine()) scanner.nextLine();

        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String pw = scanner.nextLine();

        user = accountManager.login(username, pw);

        if (user != null) {
            System.out.println("Login berhasil!");
            mainMenu();
        } else {
            System.out.println("Username atau password salah.");
        }
    }

    private void autentikasiMenu() {

        while (true) {
            System.out.print(
                "\n=== MENU AUTENTIKASI ===\n" +
                "1. Login\n" +
                "2. Registrasi\n" +
                "0. Keluar\n" +
                "Pilih: "
            );

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1 -> login();
                case 2 -> register();
                case 0 -> {
                    System.out.println("Terima Kasih!");
                    return;
                }
                default -> System.out.println("Menu tidak valid!.");
            }
        }
    }

    public void prizeMenu() {
        System.out.println("\n=== DAFTAR HADIAH SETIAP MESIN ===");

        int index = 1;
        for (Mesin m : manajerMesin.getMachines()) {
            System.out.println("\n" + index + ". " + m.getNamaMesin());
            m.lihatDaftarHadiah();
            index++;
        }

        System.out.println("\nTekan ENTER untuk kembali...");   
        scanner.nextLine();
    }

    private void mainMenu() {
        while (true) {
            
            System.out.print (
                "\n=== MENU UTAMA ===\n" +
                "1. Lihat Inventory\n" +
                "2. Tambah Coin\n" +
                "3. Cek Saldo Koin\n" +
                "4. Mulai Permainan\n" +
                "5. Logout\n" +
                "0. Keluar\n" +
                "Pilih: "
            );

            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> showInventory();
                case 2 -> tambahCoin();
                case 3 -> cekSaldo();
                case 4 -> permainan();
                case 5 -> {
                    autentikasiMenu();
                    return;
                }
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
        
        int lihatHadiah = i;
        System.out.println(lihatHadiah + ". Lihat Daftar Hadiah");

        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == lihatHadiah) {
            prizeMenu();
            return;
        }

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
