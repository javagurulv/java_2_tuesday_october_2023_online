package lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.after_registration_admin;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class caseOrederForPeriod {

    private static List<Cake>cakes = new ArrayList<>();
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
