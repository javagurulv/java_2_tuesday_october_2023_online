package lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.after_registration_admin;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.*;

public class casePrintAllClients {
    List<User> users = new ArrayList<>();

    public void printAllUsers(){
        for (User user : users){
            System.out.println(user);
        }
    }
}

