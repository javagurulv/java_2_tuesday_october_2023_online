package avangardteen.java2app.UIAction;

import avangardteen.java2app.CoreError;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.AddPersonalDataRequest;
import avangardteen.java2app.responce.AddPersonalDateResponce;
import avangardteen.java2app.service.AddUserDataServis;

import java.util.List;
import java.util.Scanner;
@Component
public class AddPersonalDateIUAction implements UIAction{
  @Autowired
  AddUserDataServis servis;

    @Override
    public void execute() {

        Scanner scan = new Scanner(System.in);
        System.out.println("введите Имя");
        String firstName = scan.nextLine();
        System.out.println("введите Фамилию");
        String secondName = scan.nextLine();
        System.out.println("введите номер телефона");
        String phoneNumber = scan.nextLine();
        System.out.println("введите е-маил, на который Вам придет выбранная детализация");
        String userEmail = scan.nextLine();
        AddPersonalDataRequest request = new AddPersonalDataRequest(firstName,secondName,phoneNumber,userEmail);
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
