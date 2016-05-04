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
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Quarter;
import bg.jwd.project.entities.Sport;
import bg.jwd.project.entities.Training;

@Repository
public class TrainingDaoImpl implements TrainingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Training addTraining(Sport sport, Club club, String instructor, Address address, String date,
            int numberPersons, Level level) {

        Training training = new Training();
        training.setSport(sport);
        training.setClub(club);
        training.setInstructor(instructor);
        training.setAddress(address);
        training.setDate(date);
        training.setNumberOfPersons(numberPersons);
        training.setLevel(level);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(training);
        tx.commit();
        session.close();

        return training;
    }

    @Override
    public Training editTraining(int id, Sport sport, Club club, String instructor, Address address, String date,
            int numberPersons, Level level) {

        Training training = getTraining(id);
        training.setSport(sport);
        training.setClub(club);
        training.setInstructor(instructor);
        training.setAddress(address);
        training.setDate(date);
        training.setNumberOfPersons(numberPersons);
        training.setLevel(level);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(training);
        tx.commit();
        session.close();

        return training;
    }

    @Override
    public Training getTraining(int Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Training.class);
        criteria.add(Restrictions.like("id", Id));
        @SuppressWarnings("unchecked")
        List<Training> trainingsList = criteria.list();
        Training Training = new Training();

        if (trainingsList.size() != 0) {
            Training = trainingsList.get(0);
        }
        return Training;
    }

    @Override
    public List<Training> getSportTraining(Sport sport) {

        // Criteria criteria =
        // sessionFactory.openSession().createCriteria(Training.class);
        // criteria.add(Restrictions.like("sportId", sportId));
        // @SuppressWarnings("unchecked")
        // List<Training> trainingsList = criteria.list();
        // Training Training = new Training();
        //
        // if (trainingsList.size() != 0) {
        // Training = trainingsList.get(0);
        // }
        // return Training;
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Training> getAllTraining() {

        Criteria criteria = sessionFactory.openSession().createCriteria(Training.class);

        return criteria.list();
    }

    @Override
    public void deleteTraining(Training training) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.delete(training);
        tx.commit();
        session.close();
    }

    @Override
    public List<Training> getFilteredTraining(Sport sport, Club club, String instructor, Quarter quarter, String City,
            String date, Level level) {
        // TODO Auto-generated method stub
        return null;
    }

}
