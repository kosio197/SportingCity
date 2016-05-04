package bg.jwd.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bg.jwd.project.dao.SeminarDaoImpl;
import bg.jwd.project.entities.Seminar;

@Service
public class SeminarserviceImpl implements Seminarservice {

    private SeminarDaoImpl seminarDao;

    @Override
    public int addSeminar(int sportId, String theme, String leadingName, int addressId, String date) {

        int id = seminarDao.addSeminar(sportId, theme, leadingName, addressId, date);

        return id;
    }

    @Override
    public Seminar editSeminar(int sportId, String theme, String leadingName, int addressId, String date) {

        Seminar seminar = seminarDao.editSeminar(sportId, theme, leadingName, addressId, date);

        return seminar;
    }

    @Override
    public Seminar getSeminar(int Id) {

        Seminar seminar = seminarDao.getSeminar(Id);

        return seminar;
    }

    @Override
    public Seminar getSportSeminar(int sportId) {

        Seminar seminar = seminarDao.getSportSeminar(sportId);

        return seminar;
    }

    @Override
    public List<Seminar> getAllSeminar() {

        List<Seminar> seminarsList = seminarDao.getAllSeminar();

        return seminarsList;
    }

    @Override
    public List<Seminar> getFilteredSeminar(int sportId, String theme, String leadingName, int addressId, String date) {

        List<Seminar> seminarsList = getAllSeminar();
        // sort by===========
        return seminarsList;
    }

    @Override
    public void deleteClub(Seminar seminar) {

        seminarDao.deleteSeminar(seminar);
    }

}
