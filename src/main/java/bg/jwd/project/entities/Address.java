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
@Table(name = "ADDRESS")
public class Address {

    @Id
    @SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    @Column(name = "ID")
    private int Id;

    @Column(name = "CITY")
    private String city;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "QUARTER_ID", insertable = true, updatable = true)
    private Quarter quarter;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSity() {
        return city;
    }

    public void setSity(String sity) {
        this.city = sity;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
