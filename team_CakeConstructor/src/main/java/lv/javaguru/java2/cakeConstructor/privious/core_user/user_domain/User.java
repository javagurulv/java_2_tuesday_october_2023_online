package lv.javaguru.java2.cakeConstructor.privious.core_user.user_domain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String userLogin;
    private String userPassword;
    private String userName;
    private  String userSurname;

    private  int status;
    private String userEmail;


    @Override
    public String toString() {
        return "User{" +
                "userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", status=" + status +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public User (String userLogin, String userPassword, String userName, String userSurname, String userEmail){
        this.userLogin=userLogin;
        this.userPassword=userPassword;
        this.userName=userName;
        this.userSurname =userSurname;
        this.userEmail=userEmail;
        this.status=0;
    }

    public User (String userLogin,String userPassword){
        this.userLogin=userLogin;
        this.userPassword=userPassword;
        this.status=0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return status == user.status &&
                Objects.equals(userLogin, user.userLogin) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userSurname, user.userSurname) &&
                Objects.equals(userEmail, user.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, userPassword, userName, userSurname,
                status, userEmail);
    }
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


}
