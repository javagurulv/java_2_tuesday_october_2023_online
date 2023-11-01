package lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake;

public class AddCakeRequestForUnregistUser {
    private String clientLogin;

    public AddCakeRequestForUnregistUser(String clientLogin){
        this.clientLogin = clientLogin;
    }

    public String getClientLogin() {
        return clientLogin;
    }
}
