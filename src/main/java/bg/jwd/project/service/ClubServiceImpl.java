package bg.jwd.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.project.dao.AddressDao;
import bg.jwd.project.dao.ClubDao;
import bg.jwd.project.dao.QuarterDao;
import bg.jwd.project.dao.SportDao;
import bg.jwd.project.entities.Address;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Quarter;
import bg.jwd.project.entities.Sport;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubDao clubDao;

    @Autowired
    private SportDao sportDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private QuarterDao quarterDao;

    @Override
    public int addClub(String clubName, String sport, String tel, String email, String address, String quarter,
            String city, String addressDescription) {
        Sport sportEntity = getOrAddSport(sport);
        Quarter quarterEntity = quarterDao.getQuarter(quarter);
        Address addressEntity = addressDao.addAddress(city, quarterEntity, address, addressDescription);

        int Id = clubDao.addClub(clubName, sportEntity, addressEntity, tel, email);

        return Id;
    }

    @Override
    public Club editClub(String clubName, String sport, String tel, String email, String address, String quarter,
            String city, String addressDescription) {

        Sport sportEntity = getOrAddSport(sport);
        Quarter quarterEntity = quarterDao.getQuarter(quarter);

        Address addressEntity = clubDao.getClub(clubName).getAddress();
        addressDao.editAddress(addressEntity.getId(), city, quarterEntity, address, addressDescription);

        Club club = clubDao.editClub(clubName, sportEntity, addressEntity, tel, email);

        return club;
    }

    @Override
    public Club getClub(int Id) {

        Club club = clubDao.getClub(Id);

        return club;
    }

    @Override
    public Club getClub(String clubName) {

        Club club = clubDao.getClub(clubName);

        return club;
    }

    @Override
    public List<Club> getAllClub() {

        List<Club> clubsList = clubDao.getAllClub();

        return clubsList;
    }

    @Override
    public List<Club> getFilterdClub(String clubName, String sport, String tel, String email, String quarted,
            String city) {

        List<Club> clubsList = getAllClub();

        return clubsList;
    }

    @Override
    public void deleteClub(Club club) {

        clubDao.deleteClub(club);

    }

    private Sport getOrAddSport(String sportName) {
        Sport sportEntity = sportDao.getSport(sportName);

        if (sportEntity == null) {
            sportEntity = sportDao.addSport(sportName);
        }

        return sportEntity;
    }

}
