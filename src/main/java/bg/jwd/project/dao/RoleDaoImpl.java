package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int addRole(String role) {

        Role next = new Role();
        next.setRole(role);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        int id = (int) session.save(next);
        tx.commit();
        session.close();

        return id;
    }

    @Override
    public Role getRole(int Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Role.class);
        criteria.add(Restrictions.like("roleId", Id));
        @SuppressWarnings("unchecked")
        List<Role> rolesList = criteria.list();
        Role next = new Role();

        if (rolesList.size() != 0) {
            next = rolesList.get(0);
        }
        return next;
    }

    @Override
    public Role getRole(String roleName) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Role.class);
        criteria.add(Restrictions.like("role", roleName));
        @SuppressWarnings("unchecked")
        List<Role> rolesList = criteria.list();
        Role next = null;

        if (rolesList.size() != 0) {
            next = rolesList.get(0);
        }
        return next;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getAllRole() {

        Criteria criteria = sessionFactory.openSession().createCriteria(Role.class);

        return criteria.list();
    }

}
