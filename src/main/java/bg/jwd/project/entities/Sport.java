package bg.jwd.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SPORT")
public class Sport {

    @Id
    @SequenceGenerator(name = "SPORT_SEQ", sequenceName = "SPORT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPORT_SEQ")
    @Column(name = "ID")
    private int sportId;

    @Column(name = "SPORT_NAME")
    private String sportName;

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
