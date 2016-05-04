package bg.jwd.project.service;

import java.util.List;

import bg.jwd.project.entities.Competition;

public interface CompetitionService {

    int addCompetition(int sportId, String competitionName, int levelId, int addressId, String date);

    Competition editCompetition(int sportId, String competitionName, int levelId, int addressId, String date);

    Competition getCompetition(int Id);

    Competition getCompetition(String competitionName);

    List<Competition> getAllCompetition();

    List<Competition> getFilteredCompetition(int sportId, String competitionName, int levelId, int addressId,
            String date);

    void deleteCompetition(Competition competition);
}
