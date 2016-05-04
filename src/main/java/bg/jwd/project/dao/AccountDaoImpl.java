package bg.jwd.project.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Account;
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Role;
import bg.jwd.project.entities.User;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private LevelDao levelDao;

    @Override
    public User getUser(String username) {

        Account account = getAccount(username);
        User user = new User();

        user.setId(account.getAccountId());
        user.setUsername(account.getAlias());
        user.setPassword(account.getPassword());
        user.setFirstName(account.getFirstName());
        user.setLastName(account.getLastName());
        user.setUserEmail(account.getUserEmail());
        user.setUserTel(account.getUserTel());
        user.setLevel(account.getLevel().getLevel());
        user.setRole(account.getRole().getRole());

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        user.setAuthorities(authorities);

        return user;
    }

    @Override
    public Account addAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, Level level, Role role) {

        String alias = username;
        Account account = new Account();

        account.setAlias(alias);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setPassword(getMD5(password));
        account.setUserEmail(userEmail);
        account.setUserTel(userTel);

        if (role == null) {
            role = roleDao.getRole("ROLE_USER");
        }

        if (level == null) {
            level = levelDao.getLevel("BEGINNERS");
        }

        account.setRole(role);
        account.setLevel(level);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(account);
        tx.commit();
        session.close();

        Account checkAccount = getAccount(username);
        return checkAccount;
    }

    @Override
    public Account editAccount(String username, String password, String firstName, String lastName, String userTel,
            String userEmail, Level level, Role role) {

        Account account = getAccount(username);
        String alias = username;
        account.setAlias(alias);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setPassword(getMD5(password));
        account.setUserEmail(userEmail);
        account.setUserTel(userTel);
        account.setLevel(level);
        account.setRole(role);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(account);
        tx.commit();
        session.close();

        Account checkAccount = getAccount(username);
        return checkAccount;
    }

    @Override
    public void deleteAccount(Account account) {

        // account.setRoleId(6); // ROLE_DELETED

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.delete(account);
        tx.commit();
        session.close();
    }

    @Override
    public Account getAccount(int Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Account.class);
        criteria.add(Restrictions.like("accountId", Id));
        @SuppressWarnings("unchecked")
        List<Account> accounts = criteria.list();
        Account account = new Account();

        if (accounts.size() != 0) {
            account = accounts.get(0);
        }
        return account;
    }

    @Override
    public Account getAccount(String username) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Account.class);
        criteria.add(Restrictions.like("alias", username));
        @SuppressWarnings("unchecked")
        List<Account> accounts = criteria.list();
        Account account = null;
        if (accounts.size() != 0) {
            account = accounts.get(0);
        }
        return account;
    }

    @Override
    public List<Account> getAllAccount() {
        Criteria criteria = sessionFactory.openSession().createCriteria(Account.class);
        @SuppressWarnings("unchecked")
        List<Account> accountsList = criteria.list();

        return accountsList;
    }

    @Override
    public List<Account> getFilteredAccount(String username, String password, String firstName, String lastName,
            String userTel, String userEmail, Integer roleId, Integer levelId) {
        // TODO Auto-generated method stub
        return null;
    }

    private static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
