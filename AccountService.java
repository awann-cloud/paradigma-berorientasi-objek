package ProjekUAS;

public interface AccountService {
    void register(String username, String password);
    Account login(String username, String password);
}
