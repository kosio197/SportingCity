package bg.jwd.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINING")
public class Training {

    @Id
    @SequenceGenerator(name = "TRAINING_SEQ", sequenceName = "TRAINING_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINING_SEQ")
    @Column(name = "ID")
    private int id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "SPORT_ID", insertable = true, updatable = true)
    private Sport sport;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CLUB_ID", insertable = true, updatable = true)
    private Club club;

    @Column(name = "INSTRUCTOR_NAME")
    private String instructor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", insertable = true, updatable = true)
    private Address address;

    @Column(name = "TRAINING_DATE")
    private String date;

    @Column(name = "NUMBER_PERSONS")
    private int numberOfPersons;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "LEVEL_ID", insertable = true, updatable = true)
    private Level level;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
