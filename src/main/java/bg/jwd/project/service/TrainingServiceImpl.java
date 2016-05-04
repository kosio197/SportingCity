package bg.jwd.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.dao.AddressDao;
import bg.jwd.project.dao.ClubDao;
import bg.jwd.project.dao.LevelDao;
import bg.jwd.project.dao.QuarterDao;
import bg.jwd.project.dao.SportDao;
import bg.jwd.project.dao.TrainingDaoImpl;
import bg.jwd.project.entities.Address;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Quarter;
import bg.jwd.project.entities.Sport;
import bg.jwd.project.entities.Training;

@Repository
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDaoImpl trainingDao;

    @Autowired
    private ClubDao clubDao;

    @Autowired
    private SportDao sportDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private QuarterDao quarterDao;

    @Autowired
    private LevelDao levelDao;

    @Override
    public Training addTraining(String sportName, String clubName, String instructor, String city, String address,
            String quarter, String addressDescription, String date, int numberPersons, String level) {

        Sport sportEntity = sportDao.getSport(sportName);
        Quarter quarterEntity = quarterDao.getQuarter(quarter);
        Address addressEntity = addressDao.addAddress(city, quarterEntity, address, addressDescription);
        Club clubEntity = clubDao.getClub(clubName);
        Level levelEntity = levelDao.getLevel(level);

        Training training = trainingDao.addTraining(sportEntity, clubEntity, instructor, addressEntity, date,
                numberPersons, levelEntity);

        return training;
    }

    @Override
    public Training editTraining(int id, String sportName, String clubName, String instructor, String city,
            String address, String quarter, String addressDescription, String date, int numberPersons, String level) {
        Sport sportEntity = sportDao.getSport(sportName);
        Quarter quarterEntity = quarterDao.getQuarter(quarter);
        Address addressEntity = addressDao.addAddress(city, quarterEntity, address, addressDescription);
        Club clubEntity = clubDao.getClub(clubName);
        Level levelEntity = levelDao.getLevel(level);

        Training training = trainingDao.editTraining(id, sportEntity, clubEntity, instructor, addressEntity, date,
                numberPersons, levelEntity);

        return training;
    }

    @Override
    public Training getTraining(int Id) {

        Training training = trainingDao.getTraining(Id);

        return training;
    }

    @Override
    public List<Training> getSportTraining(int sportId) {

        // List<Training> training = trainingDao.getSportTraining(sportId);

        return null;
    }

    @Override
    public List<Training> getAllTraining() {

        List<Training> trainingsList = trainingDao.getAllTraining();

        return trainingsList;
    }

    @Override
    public void deleteTraining(Training training) {

        trainingDao.deleteTraining(training);
    }

    @Override
    public List<Training> getFilteredTraining(String sportName, String clubName, String instructor, String city,
            String quarter, String date, String level) {

        List<Training> all = getAllTraining();
        List<Training> temp = new ArrayList<>();

        for (Training t : all) {
            if (sportName != null && !sportName.equals("") && !t.getSport().getSportName().equals(sportName)) {
                continue;
            }

            if (clubName != null && !clubName.equals("") && !t.getClub().getClubName().equals(clubName)) {
                continue;
            }

            if (quarter != null && !quarter.equals("") && !t.getAddress().getQuarter().getQuarter().equals(quarter)) {
                continue;
            }

            if (level != null && !level.equals("") && !t.getLevel().getLevel().equals(level)) {
                continue;
            }

            temp.add(t);
        }

        return temp;
    }
}
