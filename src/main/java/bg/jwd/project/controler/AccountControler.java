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
import bg.jwd.project.dao.RoleDao;
import bg.jwd.project.dao.SportDao;
import bg.jwd.project.entities.Account;
import bg.jwd.project.entities.Club;
import bg.jwd.project.entities.Level;
import bg.jwd.project.entities.Quarter;
import bg.jwd.project.entities.Sport;
import bg.jwd.project.entities.Training;
import bg.jwd.project.model.DataTransferModel;
import bg.jwd.project.service.AccountServiceImpl;
import bg.jwd.project.service.ClubService;
import bg.jwd.project.service.TrainingService;

@Controller
public class AccountControler {

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private LevelDao levelDao;
    @Autowired
    private ClubService clubService;
    @Autowired
    private SportDao sportDao;
    @Autowired
    private QuarterDao quartertDao;
    @Autowired
    private TrainingService trainingService;

    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public String viewUserRegister(Model model) {

        model.addAttribute("rolesList", roleDao.getAllRole());
        model.addAttribute("levelsList", levelDao.getAllLevel());

        return "userRegister";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userRegister(Locale locale, Model model, @ModelAttribute("DataTransferModel") DataTransferModel dtm) {
        if (userRegister(model, dtm)) {
            return "home";
        } else {
            return "userRegister";
        }
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/adminUserRegister", method = RequestMethod.GET)
    public String viewAdminUserRegister(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {
        model.addAttribute("rolesList", roleDao.getAllRole());
        model.addAttribute("levelsList", levelDao.getAllLevel());

        return "adminUserRegister";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/adminUserRegister", method = RequestMethod.POST)
    public String adminUserRegister(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {
        if (userRegister(model, dtm)) {
            return "manageAccount";
        } else {
            return "adminUserRegister";
        }
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/account", method = RequestMethod.GET)
    public String manageAccount(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        List<Account> accountsList = accountService.getAllAccount();
        model.addAttribute("accountsList", accountsList);

        return "manageAccount";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/account/edit/{Id}", method = RequestMethod.GET)
    public String manageCurrentAccount(@PathVariable("Id") Integer Id, Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        Account account = accountService.getAccount(Id);
        model.addAttribute("account", account);

        model.addAttribute("rolesList", roleDao.getAllRole());
        model.addAttribute("levelsList", levelDao.getAllLevel());

        return "userRegister";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/admin/manage/accountRegister", method = RequestMethod.GET)
    public String adminUserRegister(Model model) {

        model.addAttribute("rolesList", roleDao.getAllRole());
        model.addAttribute("levelsList", levelDao.getAllLevel());

        return "userRegister";
    }

    @Secured({ "ROLE_MAIN_ADMIN" })
    @RequestMapping(value = "/account/delete/{id}", method = RequestMethod.GET)
    public String deleteCurrentAccount(@PathVariable("id") Integer id, Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        Account account = accountService.getAccount(id);
        accountService.deleteAccount(account);

        List<Account> accountsList = accountService.getAllAccount();
        model.addAttribute("accountsList", accountsList);

        return "manageAccount";
    }

    private boolean userRegister(Model model, DataTransferModel dtm) {
        boolean added = true;
        Integer Id = dtm.getId();
        if (isNullOrEmpty(dtm.getUsername()) || isNullOrEmpty(dtm.getPassword()) || isNullOrEmpty(dtm.getFirstName())
                || isNullOrEmpty(dtm.getLastName()) || isNullOrEmpty(dtm.getUserTel())
                || isNullOrEmpty(dtm.getUserEmail())) {
            model.addAttribute("info", "All fields are mandatory!");
            return false;
        }

        if (Id == null) {
            if (accountService.getAccount(dtm.getUsername()) == null) {
                accountService.addAccount(dtm.getUsername(), dtm.getPassword(), dtm.getFirstName(), dtm.getLastName(),
                        dtm.getUserTel(), dtm.getUserEmail(), dtm.getLevel(), dtm.getRole());
                added = true;
            } else {
                model.addAttribute("info", "Username already exists");
                added = false;
            }
            model.addAttribute("rolesList", roleDao.getAllRole());

            List<Quarter> quartersList = quartertDao.getAllQuarter();
            model.addAttribute("quartersList", quartersList);

            List<Sport> sportsList = sportDao.getAllSport();
            model.addAttribute("sportsList", sportsList);

            List<Club> allClubs = clubService.getAllClub();
            model.addAttribute("clubsList", allClubs);

            List<Level> levelsList = levelDao.getAllLevel();
            model.addAttribute("levelsList", levelsList);

            List<Training> trainingsList = trainingService.getFilteredTraining(dtm.getBySport(), dtm.getByClub(), "",
                    "", dtm.getByQuarter(), "", dtm.getByLevel());
            model.addAttribute("trainingsList", trainingsList);

            List<Account> accountsList = accountService.getAllAccount();
            model.addAttribute("accountsList", accountsList);

        } else {
            accountService.editAccount(dtm.getUsername(), dtm.getPassword(), dtm.getFirstName(), dtm.getLastName(),
                    dtm.getUserTel(), dtm.getUserEmail(), dtm.getRole(), dtm.getLevel());

            List<Account> accountsList = accountService.getAllAccount();
            model.addAttribute("accountsList", accountsList);
        }

        return added;
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.equals("");
    }
}
