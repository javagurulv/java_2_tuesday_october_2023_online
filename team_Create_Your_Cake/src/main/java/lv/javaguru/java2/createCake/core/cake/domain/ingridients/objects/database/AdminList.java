package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminList {

    public List<User> listOfAdmin() {
        List<User> admins = new ArrayList<>();
        admins.add(new User("anastasiia@cake.com", "Ichiu_201294",
                "Anastasiia", "Bokareva",
                new Date(1994, 20, 12), 22375569,
                "ichiu.rain011@gmail.com", "Latvia", " "));
        return admins;
    }
}

