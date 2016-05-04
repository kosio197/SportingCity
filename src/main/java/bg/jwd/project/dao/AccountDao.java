package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Account;
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Role;
import bg.jwd.project.entities.User;

public interface AccountDao {

    User getUser(String username);

    Account addAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, Level level, Role role);

    Account editAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, Level level, Role role);

    Account getAccount(int Id);

    Account getAccount(String username);

    List<Account> getAllAccount();

    List<Account> getFilteredAccount(String username, String password, String firstName, String lastName,
            String userTel, String userEmail, Integer roleId, Integer levelId);

    void deleteAccount(Account account);
}
