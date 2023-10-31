package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.biscuits.Biscuits;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.biscuits.WorkWithBiscuits;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.decors.Decors;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.decors.WorkWithDecors;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.fillings.Fillings;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.fillings.WorkWithFillings;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.shells.Shells;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.shells.WorkWithShells;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreateCakeProcess {
    private ListOfIngridients list = new ListOfIngridients();
    private WorkWithIngridients work = new WorkWithIngridients();
    private WorkWithBiscuits b = new WorkWithBiscuits();
    private WorkWithFillings f = new WorkWithFillings();
    private WorkWithShells s = new WorkWithShells();
    private WorkWithDecors d = new WorkWithDecors();

    public Cake createCakeForNotRegistrate(User user){
        List<Biscuits> biscuits = list.createListOfBiscuit();
        List<Fillings> fillings = list.createListOfFilling();
        List<Shells> shells = list.createListOfShell();
        List<Decors> decors = list.createListOfDecor();


        String biscuit = b.biscuit(biscuits);
        int price = work.priceBiscuit(biscuits, biscuit);

        String filling = f.filling(fillings);
        price = work.priceFilling(fillings, filling) + price;

        String shell = s.shell(shells);
        price = work.priceShell(shells, shell) + price;

        String decor = d.decor(decors);
        price = work.priceDecor(decors, decor) + price;

        Cake cake1 = new Cake(biscuit,filling,shell,decor,price);
        cake1 = cakeFull(cake1, user.getUserLogin());

        return cake1;
    }
    public Cake createCakeForNotRegistrate(String userName){
        List<Biscuits> biscuits = list.createListOfBiscuit();
        List<Fillings> fillings = list.createListOfFilling();
        List<Shells> shells = list.createListOfShell();
        List<Decors> decors = list.createListOfDecor();


        String biscuit = b.biscuit(biscuits);
        int price = work.priceBiscuit(biscuits, biscuit);

        String filling = f.filling(fillings);
        price = work.priceFilling(fillings, filling) + price;

        String shell = s.shell(shells);
        price = work.priceShell(shells, shell) + price;

        String decor = d.decor(decors);
        price = work.priceDecor(decors, decor) + price;

        Cake cake1 = new Cake(biscuit,filling,shell,decor,price);
        cake1 = cakeFull(cake1,userName);

        return cake1;
    }


    private Cake cakeFull (Cake cake1,String userLogin){
        Scanner scan =  new Scanner(System.in);
        System.out.println("Do you want to order right now?");
        System.out.println("Press 1 - create an order");
        System.out.println("Press 2 - put in list for future order");
        int statusOfCake = scan.nextInt();
        Date date = dateOfPreparing(statusOfCake);
        Cake cake = new Cake(userLogin,cake1.getBiscuit(),cake1.getFilling(),cake1.getShell(),
                cake1.getDecor(), statusOfCake,date,cake1.getPrice());
        return cake;

    }

    private Date dateOfPreparing (int status){
        Date dateOfPreparing = null;
        if ( status == 1){
            dateOfPreparing = date();
        }
        return dateOfPreparing;
    }

    private Date date (){
        Scanner scan = new Scanner(System.in);
        Date dateDate = null;
        System.out.println("Please write a date for delivering (DD-MM-YYYY): ");
        String dateOfDelivery = scan.next();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateDate = dateFormat.parse(dateOfDelivery);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use DD-MM-YYYY format.");
        }
        return dateDate;
    }
}
