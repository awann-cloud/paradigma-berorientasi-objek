package ProjekUAS;

public class Account {
    protected String username;
    protected String password;

    public Account() {}

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
