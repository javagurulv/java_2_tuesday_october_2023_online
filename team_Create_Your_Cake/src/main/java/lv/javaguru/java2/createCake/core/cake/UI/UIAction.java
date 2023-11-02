package lv.javaguru.java2.createCake.core.cake.UI;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

public interface UIAction {

    void execute(String userLogin);
    void execute( User user);
    void execute( );

}
