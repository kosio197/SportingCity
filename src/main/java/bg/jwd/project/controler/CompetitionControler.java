package bg.jwd.project.controler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.project.dao.AddressDaoImpl;
import bg.jwd.project.dao.LevelDaoImpl;
import bg.jwd.project.dao.QuarterDaoImpl;
import bg.jwd.project.dao.SportDaoImpl;
import bg.jwd.project.model.DataTransferModel;
import bg.jwd.project.service.CompetitionServiceImpl;

@Controller
public class CompetitionControler {

    @Autowired
    private CompetitionServiceImpl competotonService;
    @Autowired
    private SportDaoImpl sportDao;
    @Autowired
    private AddressDaoImpl addressDao;
    @Autowired
    private QuarterDaoImpl quarterDao;
    @Autowired
    private LevelDaoImpl levelDao;

    @RequestMapping(value = "/admin/manage/competitionRegister", method = RequestMethod.GET)
    public String viewmanageCompetitionRegister(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        return "competitionRegister";
    }

    @RequestMapping(value = "/admin/manage/competitionRegister", method = RequestMethod.POST)
    public String manageCompetitionRegister(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        // int sportId = sportDao.addSport(dtm.getSportName());
        //
        // int levelId = levelDao.getLevel(dtm.getLevel()).getLevelId();
        //
        // int quarterId = quarterDao.addQuarter(dtm.getQuarter());
        //
        // int addressId = addressDao.addAddress(dtm.getCity(), quarterId,
        // dtm.getStreetNumber(), dtm.getDescription());
        //
        // competotonService.addCompetition(sportId, dtm.getCompetitionName(),
        // levelId, addressId, dtm.getDate());

        return "competitionRegister";
    }

    @RequestMapping(value = "/admin/manage/competition", method = RequestMethod.GET)
    public String viewcompetitionEdit(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        return "manageCompetition";
    }

    @RequestMapping(value = "/admin/manage/competition", method = RequestMethod.POST)
    public String competitionEdit(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        // int sportId = sportDao.addSport(dtm.getSportName());
        //
        // int levelId = levelDao.getLevel(dtm.getLevel()).getLevelId();
        //
        // int quarterId = quarterDao.addQuarter(dtm.getQuarter());
        //
        // int addressId = addressDao.addAddress(dtm.getCity(), quarterId,
        // dtm.getStreetNumber(), dtm.getDescription());
        //
        // competotonService.editCompetition(sportId, dtm.getCompetitionName(),
        // levelId, addressId, dtm.getDate());

        return "manageCompetition";
    }

}
