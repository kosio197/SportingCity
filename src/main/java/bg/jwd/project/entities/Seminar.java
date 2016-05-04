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
@Table(name = "SEMINAR")
public class Seminar {

    @Id
    @SequenceGenerator(name = "SEMINAR_SEQ", sequenceName = "SEMINAR_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEMINAR_SEQ")
    @Column(name = "ID")
    private int Id;

    @Column(name = "SPORT_NAME")
    private Integer sportId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SPORT_NAME", insertable = false, updatable = false)
    private Sport sport;

    @Column(name = "THEME")
    private String theme;

    @Column(name = "LEADING_NAME")
    private String leadingName;

    @Column(name = "SEMINAR_ADRESS")
    private Integer addressId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SEMINAR_ADRESS", insertable = false, updatable = false)
    private Address address;

    @Column(name = "SEMINAR_DATE")
    private String date;

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLeadingName() {
        return leadingName;
    }

    public void setLeadingName(String leadingName) {
        this.leadingName = leadingName;
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
