package bg.jwd.project.service;

import java.util.List;

import bg.jwd.project.entities.Seminar;

public interface Seminarservice {

    int addSeminar(int sportId, String theme, String leadingName, int addressId, String date);

    Seminar editSeminar(int sportId, String theme, String leadingName, int addressId, String date);

    Seminar getSeminar(int Id);

    Seminar getSportSeminar(int sportId);

    List<Seminar> getAllSeminar();

    List<Seminar> getFilteredSeminar(int sportId, String theme, String leadingName, int addressId, String date);

    void deleteClub(Seminar seminar);
}
