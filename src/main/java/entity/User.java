package entity;

public class User extends Entity{
    private String username;
    private String password;
    private String birthday;
    private String nickname;
    private String sex;
    private String phone;
    private String email;
    private String personalizedSignature;
    private String personalIntroduce;
    private String professionIntroduce;
    private String pic;
    private String loveIntroduce;
    private String goalIntroduce;
    private String regDate;
    private String updateDate;

    public User() {}

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String nickname, String pic) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.pic = pic;
    }

    public User(String username,String nickname, String sex,
                String phone, String email, String personalizedSignature,
                String personalIntroduce, String professionIntroduce,
                String loveIntroduce, String goalIntroduce, String updateDate) {
        this.username = username;
        this.nickname = nickname;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.personalizedSignature = personalizedSignature;
        this.personalIntroduce = personalIntroduce;
        this.professionIntroduce = professionIntroduce;
        this.loveIntroduce = loveIntroduce;
        this.goalIntroduce = goalIntroduce;
        this.updateDate = updateDate;
    }

    public User(String username, String password,
                String birthday, String nickname, String sex,
                String phone, String email, String personalizedSignature,
                String personalIntroduce, String professionIntroduce,
                String pic, String loveIntroduce, String goalIntroduce,
                String regDate, String updateDate) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.nickname = nickname;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.personalizedSignature = personalizedSignature;
        this.personalIntroduce = personalIntroduce;
        this.professionIntroduce = professionIntroduce;
        this.pic = pic;
        this.loveIntroduce = loveIntroduce;
        this.goalIntroduce = goalIntroduce;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public String getPersonalIntroduce() {
        return personalIntroduce;
    }

    public void setPersonalIntroduce(String personalIntroduce) {
        this.personalIntroduce = personalIntroduce;
    }

    public String getProfessionIntroduce() {
        return professionIntroduce;
    }

    public void setProfessionIntroduce(String professionIntroduce) {
        this.professionIntroduce = professionIntroduce;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLoveIntroduce() {
        return loveIntroduce;
    }

    public String getGoalIntroduce() {
        return goalIntroduce;
    }

    public void setGoalIntroduce(String goalIntroduce) {
        this.goalIntroduce = goalIntroduce;
    }

    public void setLoveIntroduce(String loveIntroduce) {
        this.loveIntroduce = loveIntroduce;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
