package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;

import java.util.Date;
import java.util.List;

public interface UIDatabaseCakes {

    void save (Cake cake);
    List<Cake> getAllCakes();

    List<Cake> getActiveCakeForClient(String login);

    List<Cake> getAllCakesForClient(String login);

    List<Cake> getAllCakesForPeriod(Date dateFrom, Date dateTo);
}
