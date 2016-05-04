package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Seminar;

public interface SeminarDao {

    int addSeminar(int sportId, String theme, String leadingName, int addressId, String date);

    Seminar editSeminar(int sportId, String theme, String leadingName, int addressId, String date);

    Seminar getSeminar(int Id);

    Seminar getSportSeminar(int sportId);

    List<Seminar> getAllSeminar();

    List<Seminar> getFilteredSeminar(int sportId, String theme, String leadingName, int addressId, String date);

    void deleteSeminar(Seminar seminar);
}
