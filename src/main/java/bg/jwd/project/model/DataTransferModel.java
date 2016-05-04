package bg.jwd.project.model;

public class DataTransferModel {

    // *****account
    private Integer accountId;
    private String alias;
    private String password;
    private String firstName;
    private String lastName;
    private String userTel;
    private String userEmail;
    // ***address
    private Integer Id;
    private String city;
    private String streetNumber;
    private String description;
    private Integer clubId;
    private String clubName;
    private String sport;
    private String tel;
    private String email;
    private Integer addressId;
    // ***competition
    private String competitionName;
    private String address;
    private String date;
    // ***level
    private Integer levelId;
    private String level;
    // ***quarter
    private Integer quarterId;
    private String quarter;
    // ***role
    private Integer roleId;
    private String role;
    // ***seminar
    private String theme;
    private String leadingName;
    // ***sport
    private Integer sportId;
    private String sportName;
    // ***training
    private String club;
    private String instructor;
    private Integer numberOfPersons;
    private String levalOfPersons;
    // ***user
    private String username;
    // ***search
    private String byQuarter;
    private String byClub;
    private String bySport;
    private String byLevel;

    public String getByQuarter() {
        return byQuarter;
    }

    public void setByQuarter(String byQuarter) {
        this.byQuarter = byQuarter;
    }

    public String getByClub() {
        return byClub;
    }

    public void setByClub(String byClub) {
        this.byClub = byClub;
    }

    public String getBySport() {
        return bySport;
    }

    public void setBySport(String bySport) {
        this.bySport = bySport;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
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

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(Integer quarterId) {
        this.quarterId = quarterId;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public String getLevalOfPersons() {
        return levalOfPersons;
    }

    public void setLevalOfPersons(String levalOfPersons) {
        this.levalOfPersons = levalOfPersons;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getByLevel() {
        return byLevel;
    }

    public void setByLevel(String byLevel) {
        this.byLevel = byLevel;
    }

}
