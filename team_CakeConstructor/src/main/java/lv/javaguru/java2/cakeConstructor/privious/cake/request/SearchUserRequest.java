package lv.javaguru.java2.cakeConstructor.privious.cake.request;

public class SearchUserRequest {
    private String login;
    private String userName;
    public SearchUserRequest(String login, String userName){
        this.login=login;
        this.userName=userName;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLoginProvided(){
        return this.login != null && !this.login.isEmpty();
    }
    public boolean isUserNameProvided(){
        return this.userName != null && !this.userName.isEmpty();
    }



}
