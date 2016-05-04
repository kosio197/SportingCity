package bg.jwd.project.service;

import java.util.List;

import bg.jwd.project.entities.Account;

public interface AccountService {

    Account addAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, String role, String level);

    Account editAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, String role, String level);

    Account getAccount(int Id);

    Account getAccount(String username);

    List<Account> getAllAccount();

    List<Account> getFilteredAccount(String username, String password, String firstName, String lastName,
            String userTel, String userEmail, String role, String level);

    void deleteAccount(Account account);
}
