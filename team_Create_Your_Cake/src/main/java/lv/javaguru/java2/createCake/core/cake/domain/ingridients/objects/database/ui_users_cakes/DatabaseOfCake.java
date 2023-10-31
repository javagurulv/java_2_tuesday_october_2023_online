package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DatabaseOfCake implements UIDatabaseCakes {
    private static List<Cake> cakes = new ArrayList<>();
    @Override
    public void save(Cake cake) {
        cakes.add(cake);
    }

    @Override
    public List<Cake> getAllCakes() {
        return cakes;
    }

    @Override
    public List<Cake> getActiveCakeForClient(String login) {
        List <Cake> cakeforClient = getAllCakesForClient(login);
        List<Cake> activeCakeForClient = new ArrayList<>();
        for (Cake cake:cakeforClient){
            if (cake.getStatus()!=1 || cake.getStatus()!=4 || cake.getStatus()!=5){    // 1 - отложить  2-заказать 3 - принят  4 - отказано 5-завершон
                activeCakeForClient.add(cake);
            }
        }
        return activeCakeForClient;
    }

    @Override
    public List<Cake> getAllCakesForClient(String login) {
        List<Cake> cakeForClient = new ArrayList<>();
        for (Cake cake : cakes) {
            if (cake.getUserLogin().equals(login)) {
                cakeForClient.add(cake);
            }
        }
        return cakeForClient;
    }

    @Override
    public List<Cake> getAllCakesForPeriod(Date dateFrom, Date dateTo) {
        List <Cake> listForAdmin = new ArrayList<>();
        for (Cake cake: cakes) {
            if ((cake.getStatus() == 2 || cake.getStatus() == 3) && isDateWithinRange(cake.getDateOfPreparing(), dateFrom, dateTo)) {
                listForAdmin.add(cake);
            }
        }
        return listForAdmin;

    }

    private boolean isDateWithinRange(Date date, Date dateFrom, Date dateTo){
        return !date.before(dateFrom)&& !date.after(dateTo);
    }

}
