package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Address;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Sport;
import bg.jwd.project.entities.Training;

@Repository
public class ClubDaoImpl implements ClubDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int addClub(String clubName, Sport sport, Address address, String tel, String email) {

        Club club = new Club();
        club.setClubName(clubName);
        club.setSport(sport);
        club.setAddress(address);
        club.setTel(tel);
        club.setEmail(email);

        int id = 0;
        try {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            id = (int) session.save(club);
            tx.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public Club editClub(String clubName, Sport sport, Address address, String tel, String email) {

        Club club = getClub(clubName);
        club.setSport(sport);
        club.setAddress(address);
        club.setTel(tel);
        club.setEmail(email);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(club);
        tx.commit();
        session.close();

        return club;
    }

    @Override
    public Club getClub(int Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Club.class);
        criteria.add(Restrictions.like("clubId", Id));
        @SuppressWarnings("unchecked")
        List<Club> clubsList = criteria.list();
        Club club = new Club();

        if (clubsList.size() != 0) {
            club = clubsList.get(0);
        }
        return club;
    }

    @Override
    public Club getClub(String clubName) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Club.class);
        criteria.add(Restrictions.like("clubName", clubName));
        @SuppressWarnings("unchecked")
        List<Club> clubsList = criteria.list();
        Club club = null;

        if (clubsList.size() != 0) {
            club = clubsList.get(0);
        }
        return club;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Club> getAllClub() {

        Criteria criteria = sessionFactory.openSession().createCriteria(Club.class);

        return criteria.list();
    }

    @Override
    public List<Club> getFilterdClub(String clubName, Sport sport, Address address, String tel, String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteClub(Club club) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = sessionFactory.openSession().createCriteria(Training.class);
        criteria.add(Restrictions.eq("club.clubId", club.getClubId()));
        @SuppressWarnings("unchecked")
        List<Training> trainingsList = criteria.list();

        for (Training training : trainingsList) {
            session.delete(training);
        }

        session.delete(club);
        tx.commit();
        session.close();
    }

}
