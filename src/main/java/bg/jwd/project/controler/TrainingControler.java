package bg.jwd.project.controler;

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
import bg.jwd.project.service.TrainingServiceImpl;

@Controller
public class TrainingControler {

    @Autowired
    private TrainingServiceImpl trainingService;

    @Autowired
    private LevelDao levelDao;

    @Autowired
    private QuarterDao quarterDao;

    @Autowired
    private ClubService clubService;

    @Autowired
    private SportDao sportDao;

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/trainingRegister", method = RequestMethod.GET)
    public String viewtrainingRegister(Model model, @ModelAttribute("DataTransferModel") DataTransferModel dtm) {
        List<Level> levelsList = levelDao.getAllLevel();
        List<Quarter> quartersList = quarterDao.getAllQuarter();
        List<Club> clubsList = clubService.getAllClub();
        List<Sport> sportsList = sportDao.getAllSport();

        model.addAttribute("levelsList", levelsList);
        model.addAttribute("quartersList", quartersList);
        model.addAttribute("clubsList", clubsList);
        model.addAttribute("sportsList", sportsList);

        return "trainingRegister";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/trainingRegister", method = RequestMethod.POST)
    public String trainingRegister(Model model, @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        if (dtm.getId() == null) {
            trainingService.addTraining(dtm.getSport(), dtm.getClub(), dtm.getInstructor(), dtm.getCity(),
                    dtm.getStreetNumber(), dtm.getQuarter(), dtm.getDescription(), dtm.getDate(),
                    dtm.getNumberOfPersons(), dtm.getLevel());
        } else {
            trainingService.editTraining(dtm.getId(), dtm.getSport(), dtm.getClub(), dtm.getInstructor(), dtm.getCity(),
                    dtm.getStreetNumber(), dtm.getQuarter(), dtm.getDescription(), dtm.getDate(),
                    dtm.getNumberOfPersons(), dtm.getLevel());
        }

        List<Training> trainingsList = trainingService.getAllTraining();
        model.addAttribute("trainingsList", trainingsList);

        return "manageTraining";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/training/edit/{Id}", method = RequestMethod.GET)
    public String viewmanageTraining(@PathVariable("Id") int Id, Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        Training training = trainingService.getTraining(Id);
        model.addAttribute("training", training);

        List<Level> levelsList = levelDao.getAllLevel();
        List<Quarter> quartersList = quarterDao.getAllQuarter();
        List<Club> clubsList = clubService.getAllClub();
        List<Sport> sportsList = sportDao.getAllSport();

        model.addAttribute("levelsList", levelsList);
        model.addAttribute("quartersList", quartersList);
        model.addAttribute("clubsList", clubsList);
        model.addAttribute("sportsList", sportsList);

        return "trainingRegister";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/training", method = RequestMethod.GET)
    public String viewTraining(Locale locale, Model model, @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        List<Training> trainingsList = trainingService.getAllTraining();
        model.addAttribute("trainingsList", trainingsList);

        return "manageTraining";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/training/delete/{Id}", method = RequestMethod.GET)
    public String deleteTraining(@PathVariable("Id") int Id, Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        Training training = trainingService.getTraining(Id);
        trainingService.deleteTraining(training);

        return "manageTraining";
    }
}
