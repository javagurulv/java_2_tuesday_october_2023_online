package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects;

import java.util.Date;
import java.util.Objects;

public class User {

    private String userLogin;
    private String password;
    private String userName;
    private String userSurname;
    private Date dateOfBirthDay;
    private int  userPhone;
    private String userEMail;
    private  String userAdress;
    private String userDeliveryChoice;
    private int statusOfClient;


    @Override
    public String toString() {
        return "User{" +
                " User Login = '" + userLogin + '\'' +
                ", Password = '" + password + '\'' +
                ", User Name = '" + userName + '\'' +
                ", User Surname = '" + userSurname + '\'' +
                ", Date Of BirthDay = " + dateOfBirthDay +
                ", User Phone = " + userPhone +
                ", User E-Mail = '" + userEMail + '\'' +
                ", User Adress = '" + userAdress + '\'' +
                ", User Delivery Choice = '" + userDeliveryChoice + '\'' +
                '}';
    }



    public User (String userLogin, String password, String userName, String userSurname, Date dateOfBirthDay,
                 int userPhone, String userEMail, String userAdress, String userDeliveryChoice){
        this.userLogin =userLogin;
        this.password=password;
        this.userName=userName;
        this.userSurname=userSurname;
        this.dateOfBirthDay=dateOfBirthDay;
        this.userPhone=userPhone;
        this.userEMail=userEMail;
        this.userAdress=userAdress;
        this.userDeliveryChoice=userDeliveryChoice;
        this.statusOfClient =1;
    }

    public int getStatusOfClient() {
        return statusOfClient;
    }

    public void setStatusOfClient(int statusOfClient) {
        this.statusOfClient = statusOfClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userPhone == user.userPhone && statusOfClient == user.statusOfClient && Objects.equals(userLogin, user.userLogin) && Objects.equals(password, user.password) && Objects.equals(userName, user.userName) && Objects.equals(userSurname, user.userSurname) && Objects.equals(dateOfBirthDay, user.dateOfBirthDay) && Objects.equals(userEMail, user.userEMail) && Objects.equals(userAdress, user.userAdress) && Objects.equals(userDeliveryChoice, user.userDeliveryChoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, password, userName, userSurname, dateOfBirthDay, userPhone, userEMail, userAdress, userDeliveryChoice, statusOfClient);
    }
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Date getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public void setDateOfBirthDay(Date dateOfBirthDay) {
        this.dateOfBirthDay = dateOfBirthDay;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEMail() {
        return userEMail;
    }

    public void setUserEMail(String userEMail) {
        this.userEMail = userEMail;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getUserDeliveryChoice() {
        return userDeliveryChoice;
    }

    public void setUserDeliveryChoice(String userDeliveryChoice) {
        this.userDeliveryChoice = userDeliveryChoice;
    }

}
