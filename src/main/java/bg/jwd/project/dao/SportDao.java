package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Sport;

public interface SportDao {

    Sport addSport(String sport);

    Sport getSport(int Id);

    Sport getSport(String sportName);

    List<Sport> getAllSport();

    void deleteSport(Sport sport);
}
