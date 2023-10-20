package lv.javaguru.java2.cakeConstructor.core.users.user_domain;

import lv.javaguru.java2.cakeConstructor.core.users.users_database.DatabaseUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User {

    private String userLogin;
    private int userPassword;
    private String firstName;
    private String lastName;
    private String adress;
    private int language;
    private int status;




    public User (String userLogin, int userPassword, String firstName, String lastName, String adress, int language, int status){
        this.userLogin=userLogin;
        this.userPassword=userPassword;
        this.firstName=firstName;
        this.lastName=lastName;
        this.adress=adress;
        this.language=language;
        this.status=2; // status 1 - admin, 2 - client
    }
    public User (String userLogin, int userPassword){
        this.userLogin=userLogin;
        this.userPassword=userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userPassword == user.userPassword && language == user.language && status == user.status && Objects.equals(userLogin, user.userLogin) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(adress, user.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, userPassword, firstName, lastName, adress, language, status);
    }



    public void setStatus(int status) {
        this.status = status;
    }
    public int getLanguage() {
        return language;
    }
    public void setLanguage(int language) {
        this.language = language;
    }
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public int getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(int userPassword) {
        this.userPassword = userPassword;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public User createNewUser (int userChoice, int language){
        System.out.println("Create your login and password!");
        Scanner scan = new Scanner(System.in);
        String userLogin = scan.nextLine();
        int userPassword = userChoice;
        System.out.println("Please enter your First name and Last name");
        String firstName = scan.nextLine();
        String lastName = scan.nextLine();
        String adress = scan.nextLine();
        User user = new User(userLogin,userPassword,firstName,lastName,adress,language,status);
        return user;
    }

    public User login (int userChoice, int language){
        System.out.println("Please enter your login and password!");
        Scanner scan = new Scanner(System.in);
        String userLogin = scan.nextLine();
        int userPassword = scan.nextInt();
        User user = new User(userLogin,userPassword);
        boolean success = loginUser(user.getUserLogin(),user.getUserPassword());
        if (success == true){
            return user;
        }
        return null;
    }

    public boolean loginUser (String userLogin, int userPassword) {
        boolean checkLogin = isLoginCorrect(userLogin);
        boolean checkPassword = isPasswordCorrect(userPassword);
        boolean login = false;
        if (checkPassword && checkLogin == true) {
            System.out.println("Welcome!");
            login = true;
        } else if (checkLogin == true == !checkPassword) {
            System.out.println("Password is incorrect");
        } else if (!checkLogin == true == checkPassword) {
            System.out.println("Login is incorrect!");
        } else {
            System.out.println("Login and Password are incorrect or doesn't exist");
        }
        return login;
    }


    public boolean isLoginCorrect (String userLogin){
        boolean check = false;
        DatabaseUsers databaseUsers = new DatabaseUsers();
        List<User> users = databaseUsers.getAllUsers();
        for (User user: users){
            if (userLogin== user.getUserLogin()){
                check=true;
            }
        }
        return check;
    }
    public boolean isPasswordCorrect (int userPassword){
        boolean check = false;
        DatabaseUsers databaseUsers = new DatabaseUsers();
        List<User> users = databaseUsers.getAllUsers();
        for (User user: users){
            if (userPassword == user.getUserPassword()){
                check=true;
            }
        }
        return check;
    }
}
