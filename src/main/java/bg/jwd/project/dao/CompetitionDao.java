package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Competition;

public interface CompetitionDao {

    Integer addCompetition(Integer sportId, String competitionName, Integer levelId, Integer addressId, String date);

    Competition editCompetition(Integer sportId, String competitionName, Integer levelId, Integer addressId,
            String date);

    Competition getCompetition(Integer Id);

    Competition getCompetition(String competitionName);

    List<Competition> getAllCompetition();

    List<Competition> getFilteredCompetition(Integer sportId, String competitionName, Integer levelId,
            Integer addressId, String date);

    void deleteCompetition(Competition competition);
}
