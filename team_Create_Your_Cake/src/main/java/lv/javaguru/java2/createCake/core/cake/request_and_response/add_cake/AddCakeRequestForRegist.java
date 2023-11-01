package lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

public class AddCakeRequestForRegist {
    private User user;

    public AddCakeRequestForRegist(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

