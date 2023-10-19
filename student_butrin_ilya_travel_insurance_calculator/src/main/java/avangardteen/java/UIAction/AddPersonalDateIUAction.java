package avangardteen.java.UIAction;

import avangardteen.java.Client;
import avangardteen.java.Wheelchair;
import avangardteen.java.service.AddUserDataServis;

import java.util.Scanner;

public class AddPersonalDateIUAction implements UIAction{
    AddUserDataServis servis;

    public AddPersonalDateIUAction(AddUserDataServis servis) {
        this.servis = servis;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("введите Имя и фамилию");
        String nameSurname = scan.nextLine();
        System.out.println("введите номер телефона");
        String phoneNumber = scan.nextLine();
        System.out.println("введите е-маил, на который Вам придет выбранная детализация");
        String userEmail = scan.nextLine();
        servis.addUzer(nameSurname,phoneNumber,userEmail);
        System.out.println("Данные записаны");
    }
    }
