package bg.jwd.project.controler;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.project.dao.QuarterDaoImpl;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Quarter;
import bg.jwd.project.model.DataTransferModel;
import bg.jwd.project.service.ClubServiceImpl;

@Controller
public class ClubControler {

    @Autowired
    private ClubServiceImpl clubService;

    @Autowired
    private QuarterDaoImpl quarterDao;

    @RequestMapping(value = "/admin/manage/clubRegister", method = RequestMethod.GET)
    public String clubRegisterGet(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        model.addAttribute("clubsList", clubService.getAllClub());
        List<Quarter> quartersList = quarterDao.getAllQuarter();
        model.addAttribute("quartersList", quartersList);

        return "clubRegister";
    }

    @RequestMapping(value = "/admin/manage/club/edit/{clubId}", method = RequestMethod.GET)
    public String clubViewGet(@PathVariable Integer clubId, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        List<Quarter> quartersList = quarterDao.getAllQuarter();
        model.addAttribute("quartersList", quartersList);

        model.addAttribute("club", clubService.getClub(clubId));

        return "clubRegister";
    }

    @RequestMapping(value = "/admin/manage/clubRegister", method = RequestMethod.POST)
    public String clubRegister(Locale locale, Model model, @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        if (dtm.getId() == null) {
            if (clubService.getClub(dtm.getClubName()) == null) {
                clubService.addClub(dtm.getClubName(), dtm.getSport(), dtm.getTel(), dtm.getEmail(),
                        dtm.getStreetNumber(), dtm.getQuarter(), dtm.getCity(), dtm.getDescription());
            } else {
                model.addAttribute("info", "Club already exists!");
            }

        } else {
            clubService.editClub(dtm.getClubName(), dtm.getSport(), dtm.getTel(), dtm.getEmail(), dtm.getStreetNumber(),
                    dtm.getQuarter(), dtm.getCity(), dtm.getDescription());
        }

        model.addAttribute("clubsList", clubService.getAllClub());

        return "manageClub";
    }

    @RequestMapping(value = "/admin/manage/club", method = RequestMethod.GET)
    public String manageClubGet(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        model.addAttribute("clubsList", clubService.getAllClub());

        return "manageClub";
    }

    @RequestMapping(value = "/admin/manage/club/delete/{clubId}", method = RequestMethod.GET)
    public String deleteClub(@PathVariable Integer clubId, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        Club club = clubService.getClub(clubId);
        clubService.deleteClub(club);

        model.addAttribute("clubsList", clubService.getAllClub());

        return "manageClub";
    }
}
