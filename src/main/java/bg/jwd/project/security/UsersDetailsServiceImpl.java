package bg.jwd.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.jwd.project.dao.AccountDaoImpl;
import bg.jwd.project.entities.User;

public class UsersDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AccountDaoImpl acountDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = acountDao.getUser(username);

        if (user == null) {
            throw new AuthenticationServiceException("Invalid Credentials");
        }

        return user;
    }
}
