package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Seminar;

@Repository
public class SeminarDaoImpl implements SeminarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int addSeminar(int sportId, String theme, String leadingName, int addressId, String date) {

        Seminar seminar = new Seminar();
        seminar.setSportId(sportId);
        seminar.setTheme(theme);
        seminar.setLeadingName(leadingName);
        seminar.setAddressId(addressId);
        seminar.setDate(date);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        int id = (int) session.save(seminar);
        tx.commit();
        session.close();

        return id;
    }

    @Override
    public Seminar editSeminar(int sportId, String theme, String leadingName, int addressId, String date) {

        Seminar seminar = new Seminar();
        seminar.setSportId(sportId);
        seminar.setTheme(theme);
        seminar.setLeadingName(leadingName);
        seminar.setAddressId(addressId);
        seminar.setDate(date);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(seminar);
        tx.commit();
        session.close();

        return seminar;
    }

    @Override
    public Seminar getSeminar(int Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Seminar.class);
        criteria.add(Restrictions.like("Id", Id));
        @SuppressWarnings("unchecked")
        List<Seminar> seminarsList = criteria.list();
        Seminar seminar = new Seminar();

        if (seminarsList.size() != 0) {
            seminar = seminarsList.get(0);
        }
        return seminar;
    }

    @Override
    public Seminar getSportSeminar(int sportId) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Seminar.class);
        criteria.add(Restrictions.like("sportId", sportId));
        @SuppressWarnings("unchecked")
        List<Seminar> seminarsList = criteria.list();
        Seminar seminar = new Seminar();

        if (seminarsList.size() != 0) {
            seminar = seminarsList.get(0);
        }
        return seminar;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Seminar> getAllSeminar() {

        Criteria criteria = sessionFactory.openSession().createCriteria(Seminar.class);

        return criteria.list();
    }

    @Override
    public List<Seminar> getFilteredSeminar(int sportId, String theme, String leadingName, int addressId, String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteSeminar(Seminar seminar) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(seminar);
        tx.commit();
        session.close();
    }

}
