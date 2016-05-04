package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Address;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Sport;

public interface ClubDao {

    int addClub(String clubName, Sport sport, Address address, String tel, String email);

    Club editClub(String clubName, Sport sport, Address address, String tel, String email);

    Club getClub(int Id);

    Club getClub(String clubName);

    List<Club> getAllClub();

    List<Club> getFilterdClub(String clubName, Sport sport, Address address, String tel, String email);

    void deleteClub(Club club);
}
