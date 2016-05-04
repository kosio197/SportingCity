package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Sport;

@Repository
public class SportDaoImpl implements SportDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Sport addSport(String sport) {

        Sport next = getSport(sport);

        if (next != null) {
            throw new RuntimeException("Sport already exists");
        }

        next = new Sport();
        next.setSportName(sport);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(next);
        tx.commit();
        session.close();

        return getSport(sport);

    }

    @Override
    public Sport getSport(int Id) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Sport.class);
        criteria.add(Restrictions.like("sportId", Id));
        @SuppressWarnings("unchecked")
        List<Sport> sportsList = criteria.list();
        Sport sport = new Sport();

        if (sportsList.size() != 0) {
            sport = sportsList.get(0);
        }

        session.close();

        return sport;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Sport> getAllSport() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Sport.class);
        return criteria.list();
    }

    @Override
    public Sport getSport(String sportName) {

        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Sport.class);
        criteria.add(Restrictions.like("sportName", sportName));
        @SuppressWarnings("unchecked")
        List<Sport> sportsList = criteria.list();
        Sport sport = null;

        if (sportsList.size() != 0) {
            sport = sportsList.get(0);
        }

        session.close();
        return sport;
    }

    @Override
    public void deleteSport(Sport sport) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.delete(sport);
        tx.commit();
        session.close();
    }

}
