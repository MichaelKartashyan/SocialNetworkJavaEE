package Models;

public class Users {
   private Long id;
   private String name;
   private String surname;
   private String password;
   private String email;
    private String university;
    private String about;
    private String birthdate;
    private String gender;
    private String city;
    private int phone;
    private String imagePath;
    private int followersCount;
    private int subscribersCount;
    private int postCount;


    public Users() {
    }

    public Users(String name, String surname, String password, String email, String birthdate, String gender) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Users(Long id, String name, String surname, String imagePath) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.imagePath = imagePath;
    }

    public Users(Long id, String name, String surname, String password, String email, String university, String about, String birthdate, String gender, String city, int phone, String imagePath, int followersCount, int subscribersCount, int postCount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.university = university;
        this.about = about;
        this.birthdate = birthdate;
        this.gender = gender;
        this.city = city;
        this.phone = phone;
        this.imagePath = imagePath;
        this.followersCount = followersCount;
        this.subscribersCount = subscribersCount;
        this.postCount = postCount;
    }

    public Users(String name, String surname, String password, String email, String university, String about, String birthdate, String gender, String city, int phone, String imagePath, int followersCount, int subscribersCount, int postCount) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.university = university;
        this.about = about;
        this.birthdate = birthdate;
        this.gender = gender;
        this.city = city;
        this.phone = phone;
        this.imagePath = imagePath;
        this.followersCount = followersCount;
        this.subscribersCount = subscribersCount;
        this.postCount = postCount;
    }

    public Users(Long id, String name, String surname, String email, String university, String about, String birthdate, String gender, String city, int phone, String imagePath, int followersCount, int subscribersCount, int postCount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.university = university;
        this.about = about;
        this.birthdate = birthdate;
        this.gender = gender;
        this.city = city;
        this.phone = phone;
        this.imagePath = imagePath;
        this.followersCount = followersCount;
        this.subscribersCount = subscribersCount;
        this.postCount = postCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(int subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", university='" + university + '\'' +
                ", about='" + about + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", phone=" + phone +
                ", imagePath='" + imagePath + '\'' +
                ", followersCount=" + followersCount +
                ", subscribersCount=" + subscribersCount +
                ", postCount=" + postCount +
                '}';
    }
}
