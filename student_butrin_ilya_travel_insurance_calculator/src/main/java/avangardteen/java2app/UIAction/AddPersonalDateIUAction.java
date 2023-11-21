package avangardteen.java2app.UIAction;

import avangardteen.java2app.CoreError;

import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.request.AddPersonalDataRequest;
import avangardteen.java2app.responce.AddPersonalDateResponce;
import avangardteen.java2app.service.AddUserDataServis;

import java.util.List;
import java.util.Scanner;
@DIComponent
public class AddPersonalDateIUAction implements UIAction{
  @DIDependency
  AddUserDataServis servis;

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
