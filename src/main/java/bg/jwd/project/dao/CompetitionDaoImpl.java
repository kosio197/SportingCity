package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Competition;

@Repository
public class CompetitionDaoImpl implements CompetitionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer addCompetition(Integer sportId, String competitionName, Integer levelId, Integer addressId,
            String date) {

        Competition competition = new Competition();
        competition.setSportId(sportId);
        competition.setCompetitionName(competitionName);
        competition.setLevelId(levelId);
        competition.setAddressId(addressId);
        competition.setDate(date);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Integer id = (Integer) session.save(competition);
        tx.commit();
        session.close();

        return id;
    }

    @Override
    public Competition editCompetition(Integer sportId, String competitionName, Integer levelId, Integer addressId,
            String date) {

        Competition competition = new Competition();
        competition.setSportId(sportId);
        competition.setCompetitionName(competitionName);
        competition.setLevelId(levelId);
        competition.setAddressId(addressId);
        competition.setDate(date);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(competition);
        tx.commit();
        session.close();

        return competition;
    }

    @Override
    public Competition getCompetition(Integer Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Competition.class);
        criteria.add(Restrictions.like("Id", Id));
        @SuppressWarnings("unchecked")
        List<Competition> competitionsList = criteria.list();
        Competition competition = new Competition();

        if (competitionsList.size() != 0) {
            competition = competitionsList.get(0);
        }
        return competition;
    }

    @Override
    public Competition getCompetition(String competitionName) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Competition.class);
        criteria.add(Restrictions.like("competitionName", competitionName));
        @SuppressWarnings("unchecked")
        List<Competition> competitionsList = criteria.list();
        Competition competition = new Competition();

        if (competitionsList.size() != 0) {
            competition = competitionsList.get(0);
        }
        return competition;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Competition> getAllCompetition() {

        Criteria criteria = sessionFactory.openSession().createCriteria(Competition.class);

        return criteria.list();
    }

    @Override
    public List<Competition> getFilteredCompetition(Integer sportId, String competitionName, Integer levelId,
            Integer addressId, String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteCompetition(Competition competition) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.delete(competition);
        tx.commit();
        session.close();
    }

}
