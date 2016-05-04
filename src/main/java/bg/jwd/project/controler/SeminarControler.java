package bg.jwd.project.controler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.project.dao.AddressDaoImpl;
import bg.jwd.project.dao.QuarterDaoImpl;
import bg.jwd.project.dao.SportDaoImpl;
import bg.jwd.project.model.DataTransferModel;
import bg.jwd.project.service.SeminarserviceImpl;

@Controller
public class SeminarControler {

    @Autowired
    private QuarterDaoImpl quarterDao;
    @Autowired
    private AddressDaoImpl addressDao;
    @Autowired
    private SportDaoImpl sportDao;
    @Autowired
    private SeminarserviceImpl seminarservice;

    @RequestMapping(value = "/admin/manage/seminarRegister", method = RequestMethod.GET)
    public String seminarRegister(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        // int sportId = sportDao.addSport(dtm.getSportName());
        //
        // int quarterId = quarterDao.addQuarter(dtm.getQuarter());
        //
        // int addressId = addressDao.addAddress(dtm.getCity(), quarterId,
        // dtm.getStreetNumber(), dtm.getDescription());
        //
        // seminarservice.addSeminar(sportId, dtm.getTheme(),
        // dtm.getLeadingName(), addressId, dtm.getDate());

        return "seminarRegister";
    }

    @RequestMapping(value = "/admin/manage/seminar", method = RequestMethod.GET)
    public String manageSeminar(Locale locale, Model model,
            @ModelAttribute("DataTransferModel") DataTransferModel dtm) {

        // int sportId = sportDao.addSport(dtm.getSportName());
        //
        // int quarterId = quarterDao.addQuarter(dtm.getQuarter());
        //
        // int addressId = addressDao.addAddress(dtm.getCity(), quarterId,
        // dtm.getStreetNumber(), dtm.getDescription());
        //
        // seminarservice.editSeminar(sportId, dtm.getTheme(),
        // dtm.getLeadingName(), addressId, dtm.getDate());

        return "manageSeminar";
    }

}
