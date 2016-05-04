package bg.jwd.project.service;

import java.util.List;

import bg.jwd.project.entities.Training;

public interface TrainingService {

    Training addTraining(String sportName, String clubName, String instructor, String city, String address,
            String quarter, String addressDescription, String date, int numberPersons, String level);

    Training editTraining(int id, String sportName, String clubName, String instructor, String city, String address,
            String quarter, String addressDescription, String date, int numberPersons, String level);

    Training getTraining(int Id);

    List<Training> getSportTraining(int sportId);

    List<Training> getAllTraining();

    List<Training> getFilteredTraining(String sportName, String clubName, String instructor, String city,
            String quarter, String date, String level);

    void deleteTraining(Training training);
}
