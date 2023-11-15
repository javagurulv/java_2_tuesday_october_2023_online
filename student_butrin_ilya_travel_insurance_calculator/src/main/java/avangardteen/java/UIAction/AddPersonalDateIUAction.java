package avangardteen.java.UIAction;

import avangardteen.java.Client;
import avangardteen.java.CoreError;
import avangardteen.java.Wheelchair;
import avangardteen.java.request.AddPersonalDataRequest;
import avangardteen.java.responce.AddPersonalDateResponce;
import avangardteen.java.service.AddUserDataServis;

import java.util.List;
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
        AddPersonalDataRequest request = new AddPersonalDataRequest(nameSurname,phoneNumber,userEmail);
        AddPersonalDateResponce responce = servis.addUzer(request);
        if (responce.hasErrors()){
            List<CoreError> errors = responce.getErrorList();
            for (CoreError error : errors) {
                System.err.println(error.getLocation() + ": " + error.getMessage());}}
        else{
        System.out.println("Данные записаны");
            System.exit(0);}
    }
    }
