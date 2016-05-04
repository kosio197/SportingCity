package bg.jwd.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bg.jwd.project.dao.CompetitionDaoImpl;
import bg.jwd.project.entities.Competition;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private CompetitionDaoImpl competitionDao;

    @Override
    public int addCompetition(int sportId, String competitionName, int levelId, int addressId, String date) {

        int id = competitionDao.addCompetition(sportId, competitionName, levelId, addressId, date);

        return id;
    }

    @Override
    public Competition editCompetition(int sportId, String competitionName, int levelId, int addressId, String date) {

        Competition competition = competitionDao.editCompetition(sportId, competitionName, levelId, addressId, date);

        return competition;
    }

    @Override
    public Competition getCompetition(int Id) {

        Competition competition = competitionDao.getCompetition(Id);

        return competition;
    }

    @Override
    public Competition getCompetition(String competitionName) {

        Competition competition = competitionDao.getCompetition(competitionName);

        return competition;
    }

    @Override
    public List<Competition> getAllCompetition() {

        List<Competition> competitionsList = competitionDao.getAllCompetition();

        return competitionsList;
    }

    @Override
    public List<Competition> getFilteredCompetition(int sportId, String competitionName, int levelId, int addressId,
            String date) {
        List<Competition> competitionsList = getAllCompetition();

        // Sort by............
        return competitionsList;
    }

    @Override
    public void deleteCompetition(Competition competition) {

        competitionDao.deleteCompetition(competition);

    }

}
