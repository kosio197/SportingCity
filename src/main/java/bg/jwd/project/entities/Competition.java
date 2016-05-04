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
@Table(name = "COMPETITION")
public class Competition {

    @Id
    @SequenceGenerator(name = "COMPETITION_SEQ", sequenceName = "COMPETITION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPETITION_SEQ")
    @Column(name = "ID")
    private int Id;

    @Column(name = "SPORT_NAME")
    private Integer sportId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SPORT_NAME", insertable = false, updatable = false)
    private Sport sport;

    @Column(name = "COMPETITION_NAME")
    private String competitionName;

    @Column(name = "COMPETITION_LEVEL_ID")
    private Integer levelId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPETITION_LEVEL_ID", insertable = false, updatable = false)
    private Level level;

    @Column(name = "COMPETITION_ADRESS_ID")
    private Integer addressId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPETITION_ADRESS_ID", insertable = false, updatable = false)
    private Address address;

    @Column(name = "COMPETITION_DATE")
    private String date;

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Address getAdress() {
        return address;
    }

    public void setAdress(Address address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
