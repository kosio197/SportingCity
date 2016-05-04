package bg.jwd.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.project.dao.AccountDao;
import bg.jwd.project.dao.LevelDaoImpl;
import bg.jwd.project.dao.RoleDao;
import bg.jwd.project.entities.Account;
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Role;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LevelDaoImpl levelDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public Account addAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, String level, String role) {
        Level l = levelDao.getLevel(level);
        Role r = roleDao.getRole(role);

        Account account = accountDao.addAccount(username, password, firstName, lastName, userTel, userEmail, l, r);

        return account;
    }

    @Override
    public Account editAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, String role, String level) {

        Level l = levelDao.getLevel(level);
        Role r = roleDao.getRole(role);

        Account account = accountDao.editAccount(username, password, firstName, lastName, userTel, userEmail, l, r);

        return account;
    }

    @Override
    public Account getAccount(int Id) {

        Account account = accountDao.getAccount(Id);

        return account;
    }

    @Override
    public Account getAccount(String username) {

        Account account = accountDao.getAccount(username);

        return account;
    }

    @Override
    public List<Account> getAllAccount() {

        List<Account> accountsList = accountDao.getAllAccount();

        return accountsList;
    }

    @Override
    public List<Account> getFilteredAccount(String username, String password, String firstName, String lastName,
            String userTel, String userEmail, String role, String level) {

        List<Account> accountsList = null;
        // accountDao.getFilteredAccount(username, password, firstName,
        // lastName, userTel,userEmail, roleId, levelId);

        return accountsList;
    }

    @Override
    public void deleteAccount(Account account) {

        accountDao.deleteAccount(account);

    }

}
