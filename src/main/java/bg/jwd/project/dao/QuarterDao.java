package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Quarter;

public interface QuarterDao {

    int addQuarter(String quarter);

    Quarter getQuarter(int quarterId);

    Quarter getQuarter(String quarter);

    List<Quarter> getAllQuarter();

    void deleteQuarter(Quarter quarter);
}
