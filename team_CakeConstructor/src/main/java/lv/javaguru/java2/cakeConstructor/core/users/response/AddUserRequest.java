package lv.javaguru.java2.cakeConstructor.core.users.response;

public class AddUserRequest {

    private int userChoice;
    private int language;




    public AddUserRequest (int userChoice, int language){
        this.userChoice=userChoice;
        this.language=language;
    }
    public int getLanguage() {
        return language;
    }
    public int getUserChoice() {
        return userChoice;
    }
}
