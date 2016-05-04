package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Quarter;

@Repository
public class QuarterDaoImpl implements QuarterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int addQuarter(String quarter) {

        Quarter next = getQuarter(quarter);

        if (next.getQuarter() != null) {
            return next.getQuarterId();
        }

        next.setQuarter(quarter);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        int id = (int) session.save(next);
        tx.commit();
        session.close();

        return id;
    }

    @Override
    public Quarter getQuarter(int quarterId) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Quarter.class);
        criteria.add(Restrictions.like("quarterId", quarterId));
        @SuppressWarnings("unchecked")
        List<Quarter> quartersList = criteria.list();
        Quarter quarter = new Quarter();

        if (quartersList.size() != 0) {
            quarter = quartersList.get(0);
        }
        return quarter;
    }

    @Override
    public Quarter getQuarter(String quarter) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Quarter.class);
        criteria.add(Restrictions.like("quarter", quarter));
        @SuppressWarnings("unchecked")
        List<Quarter> quartersList = criteria.list();
        Quarter quarter1 = new Quarter();

        if (quartersList.size() != 0) {
            quarter1 = quartersList.get(0);
        }
        return quarter1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Quarter> getAllQuarter() {

        Criteria criteria = sessionFactory.openSession().createCriteria(Quarter.class);

        return criteria.list();
    }

    @Override
    public void deleteQuarter(Quarter quarter) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.delete(quarter);
        tx.commit();
        session.close();
    }

}
