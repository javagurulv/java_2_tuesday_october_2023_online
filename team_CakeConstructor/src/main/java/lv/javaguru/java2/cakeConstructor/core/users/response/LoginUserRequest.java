package lv.javaguru.java2.cakeConstructor.core.users.response;

public class LoginUserRequest {
    private int userChoice;
    private int language;



    public LoginUserRequest (int userChoice, int language){
        this.userChoice=userChoice;
        this.language = language;
    }
    public int getUserChoice() {
        return userChoice;
    }

    public int getLanguage() {
        return language;
    }
}
