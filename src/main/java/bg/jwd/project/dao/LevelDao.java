package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Level;

public interface LevelDao {

    int addLevel(String level);

    Level getLevel(int Id);

    Level getLevel(String level);

    List<Level> getAllLevel();
}
