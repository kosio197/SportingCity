package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Address;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Quarter;
import bg.jwd.project.entities.Sport;
import bg.jwd.project.entities.Training;

public interface TrainingDao {

    Training addTraining(Sport sport, Club club, String instructor, Address address, String date, int numberPersons,
            Level level);

    Training editTraining(int id, Sport sport, Club club, String instructor, Address address, String date,
            int numberPersons, Level level);

    Training getTraining(int Id);

    List<Training> getSportTraining(Sport sport);

    List<Training> getAllTraining();

    List<Training> getFilteredTraining(Sport sport, Club club, String instructor, Quarter quarter, String City,
            String date, Level level);

    void deleteTraining(Training training);
}
