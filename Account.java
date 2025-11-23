package ProjekUAS;

    public class Account {
    protected String username;
    protected String password;
    private int coins;
    private Inventory inventory;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.coins = 0;
        this.inventory = new Inventory();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return this.username;
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


