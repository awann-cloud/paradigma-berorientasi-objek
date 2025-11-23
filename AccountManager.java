package ProjekUAS;

import java.util.ArrayList;
import java.util.List;

public class AccountManager implements AccountService {
    private List<Account> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
    }

    @Override
    public void register(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                System.out.println("Username sudah digunakan!");
                return;
            }
        }

        Account newAcc = new Account(username, password);
        accounts.add(newAcc);

        System.out.println("Registrasi berhasil! Silakan login.");
    }

    public Account login(String username, String password) {
        for (Account acc : accounts) {
            if (acc.login(username, password)) {
                return acc;
            }
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    
}
