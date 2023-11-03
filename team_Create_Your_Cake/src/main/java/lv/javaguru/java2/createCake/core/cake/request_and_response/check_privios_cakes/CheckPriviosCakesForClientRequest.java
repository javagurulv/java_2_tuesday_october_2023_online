package lv.javaguru.java2.createCake.core.cake.request_and_response.check_privios_cakes;


public class CheckPriviosCakesForClientRequest {

    private String userLogin;



    public CheckPriviosCakesForClientRequest (String userLogin){
        this.userLogin=userLogin;
    }
    public String getUserLogin() {
        return userLogin;
    }
}
