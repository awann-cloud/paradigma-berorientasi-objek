package ProjekUAS;

    public class UserAccount extends Account {
    private int coins;
    private Inventory inventory;

    public UserAccount(String username, String pw) {
        this.username = username;
        this.password = pw;
        this.coins = 0;
        this.inventory = new Inventory();
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int jumlah) {
        this.coins += jumlah;
    }
}


