package ProjekUAS;

public class Main {
    public static void main(String[] args) {
        UserAccount user = new UserAccount("fuira", "123");

        GameApp app = new GameApp();
        app.start();
    }
}
