package bg.jwd.project.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.project.dao.LevelDao;
import bg.jwd.project.dao.QuarterDao;
import bg.jwd.project.dao.SportDao;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Quarter;
import bg.jwd.project.entities.Sport;
import bg.jwd.project.entities.Training;
import bg.jwd.project.model.DataTransferModel;
import bg.jwd.project.service.ClubService;
import bg.jwd.project.service.TrainingService;

@Controller
public class LinkControler {

    @Autowired
    private ClubService clubService;
    @Autowired
    private SportDao sportDao;
    @Autowired
    private LevelDao levelDao;
    @Autowired
    private QuarterDao quartertDao;
    @Autowired
    private TrainingService trainingService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model, @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        List<Quarter> quartersList = quartertDao.getAllQuarter();
        model.addAttribute("quartersList", quartersList);

        List<Sport> sportsList = sportDao.getAllSport();
        model.addAttribute("sportsList", sportsList);

        List<Club> allClubs = clubService.getAllClub();
        model.addAttribute("clubsList", allClubs);

        List<Level> levelsList = levelDao.getAllLevel();
        model.addAttribute("levelsList", levelsList);

        List<Training> trainingsList = trainingService.getFilteredTraining(dtm.getBySport(), dtm.getByClub(), "", "",
                dtm.getByQuarter(), "", dtm.getByLevel());
        model.addAttribute("trainingsList", trainingsList);

        return "home";
    }

    @RequestMapping(value = "/currentSport/{sportName}", method = RequestMethod.GET)
    public String currentSport(@PathVariable("sportName") String sportName, Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        model.addAttribute("sportName", sportName);

        List<Club> clubsList = new ArrayList<>();
        List<Club> allClubs = clubService.getAllClub();
        for (Club club : allClubs) {
            if (club.getSport().getSportName().equals(sportName)) {
                clubsList.add(club);
            }
        }
        model.addAttribute("clubsList", clubsList);

        List<Training> trainingsList = new ArrayList<>();
        List<Training> allTraining = trainingService.getAllTraining();
        for (Training training : allTraining) {
            if (training.getSport().getSportName().equals(sportName)) {
                trainingsList.add(training);
            }
        }
        model.addAttribute("trainingsList", trainingsList);
        //
        // List<Competition> competitionsList = new ArrayList<>();
        // List<Competition> Allcompetition =
        // competitionService.getAllCompetition();
        // for (Competition competition : Allcompetition) {
        // if (competition.getSport().getSportName().equals(sportName)) {
        // Allcompetition.add(competition);
        // }
        // }
        // model.addAttribute("competitionsList", competitionsList);
        //
        // List<Seminar> seminarsList = new ArrayList<>();
        // List<Seminar> allSeminars = seminarservice.getAllSeminar();
        // for (Seminar seminar : allSeminars) {
        // if (seminar.getSport().getSportName().equals(sportName)) {
        // seminarsList.add(seminar);
        // }
        // }
        // model.addAttribute("seminarsList", seminarsList);

        return "currentSport";
    }

    @RequestMapping(value = "/currentClub/{clubName}", method = RequestMethod.GET)
    public String currentClub(@PathVariable("clubName") String clubName, Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        Club club = clubService.getClub(clubName);
        model.addAttribute("currentClub", club);

        List<Training> trainingsList = new ArrayList<>();
        List<Training> allTraining = trainingService.getAllTraining();
        for (Training training : allTraining) {
            if (training.getClub().getClubName().equals(clubName)) {
                trainingsList.add(training);
            }
        }
        model.addAttribute("trainingsList", trainingsList);

        // List<Competition> competitionsList = new ArrayList<>();
        // List<Competition> Allcompetition =
        // competitionService.getAllCompetition();
        // for (Competition competition : Allcompetition) {
        // if (competition.getSport().getSportName().equals(sportName)) {
        // Allcompetition.add(competition);
        // }
        // }
        // model.addAttribute("competitionsList", competitionsList);
        //
        // List<Seminar> seminarsList = new ArrayList<>();
        // List<Seminar> allSeminars = seminarservice.getAllSeminar();
        // for (Seminar seminar : allSeminars) {
        // if (seminar.getSport().getSportName().equals(sportName)) {
        // seminarsList.add(seminar);
        // }
        // }
        // model.addAttribute("seminarsList", seminarsList);

        return "currentClub";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public String adminPanel(Locale locale, Model model, @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        return "adminPanel";
    }

    @RequestMapping(value = "/selectTraining/{id}", method = RequestMethod.GET)
    public String deleteCurrentAccount(@PathVariable("id") Integer id, Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        Training training = trainingService.getTraining(id);

        if (training.getNumberOfPersons() > 0) {
            trainingService.editTraining(id, training.getSport().getSportName(), training.getClub().getClubName(),
                    training.getInstructor(), training.getAddress().getCity(), training.getAddress().getStreetNumber(),
                    training.getAddress().getQuarter().getQuarter(), training.getAddress().getDescription(),
                    training.getDate(), training.getNumberOfPersons() - 1, training.getLevel().getLevel());
        }

        List<Quarter> quartersList = quartertDao.getAllQuarter();
        model.addAttribute("quartersList", quartersList);

        List<Sport> sportsList = sportDao.getAllSport();
        model.addAttribute("sportsList", sportsList);

        List<Club> allClubs = clubService.getAllClub();
        model.addAttribute("clubsList", allClubs);

        List<Level> levelsList = levelDao.getAllLevel();
        model.addAttribute("levelsList", levelsList);

        List<Training> trainingsList = trainingService.getFilteredTraining(dtm.getBySport(), dtm.getByClub(), "", "",
                dtm.getByQuarter(), "", dtm.getByLevel());
        model.addAttribute("trainingsList", trainingsList);

        return "home";
    }
}
