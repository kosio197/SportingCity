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
@Table(name = "CLUB")
public class Club {

    @Id
    @SequenceGenerator(name = "CLUB_SEQ", sequenceName = "CLUB_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLUB_SEQ")
    @Column(name = "ID")
    private int clubId;

    @Column(name = "CLUB_NAME")
    private String clubName;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "SPORT_ID", insertable = true, updatable = true)
    private Sport sport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", insertable = true, updatable = true)
    private Address address;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "EMAIL")
    private String email;

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
