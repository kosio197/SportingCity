package bg.jwd.project.service;

import java.util.List;

import bg.jwd.project.entities.Club;

public interface ClubService {

    int addClub(String clubName, String sport, String tel, String email, String address, String quarted, String city,
            String addressDescription);

    Club editClub(String clubName, String sport, String tel, String email, String address, String quarted, String city,
            String addressDescription);

    Club getClub(int Id);

    Club getClub(String clubName);

    List<Club> getAllClub();

    List<Club> getFilterdClub(String clubName, String sport, String tel, String email, String quarted, String city);

    void deleteClub(Club club);
}
