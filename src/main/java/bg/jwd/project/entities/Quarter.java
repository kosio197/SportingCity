package bg.jwd.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUARTER")
public class Quarter {

    @Id
    @Column(name = "ID")
    private int quarterId;

    @Column(name = "QUARTER")
    private String quarter;

    public int getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(int quarterId) {
        this.quarterId = quarterId;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
}
