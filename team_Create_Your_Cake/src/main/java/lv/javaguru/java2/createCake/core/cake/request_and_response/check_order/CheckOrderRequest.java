package lv.javaguru.java2.createCake.core.cake.request_and_response.check_order;

public class CheckOrderRequest {
    private String userLogin;



    public CheckOrderRequest (String userLogin){
        this.userLogin=userLogin;
    }
    public String getUserLogin() {
        return userLogin;
    }
}
