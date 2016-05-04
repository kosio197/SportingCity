package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Level;

@Repository
public class LevelDaoImpl implements LevelDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int addLevel(String level) {

        Level next = new Level();
        next.setLevel(level);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        int id = (int) session.save(next);
        tx.commit();
        session.close();

        return id;
    }

    @Override
    public Level getLevel(int Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Level.class);
        criteria.add(Restrictions.like("levelId", Id));
        @SuppressWarnings("unchecked")
        List<Level> levelsList = criteria.list();
        Level level = new Level();

        if (levelsList.size() != 0) {
            level = levelsList.get(0);
        }
        return level;
    }

    @Override
    public Level getLevel(String level) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Level.class);
        criteria.add(Restrictions.like("level", level));
        @SuppressWarnings("unchecked")
        List<Level> levelsList = criteria.list();
        Level currentLevel = null;

        if (levelsList.size() != 0) {
            currentLevel = levelsList.get(0);
        }
        return currentLevel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Level> getAllLevel() {
        Criteria criteria = sessionFactory.openSession().createCriteria(Level.class);
        return criteria.list();
    }

}
