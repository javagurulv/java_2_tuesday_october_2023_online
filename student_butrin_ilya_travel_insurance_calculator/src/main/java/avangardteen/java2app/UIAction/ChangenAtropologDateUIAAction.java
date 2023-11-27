package avangardteen.java2app.UIAction;

import avangardteen.java2app.CoreError;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChangeAntropologDateRequest;
import avangardteen.java2app.responce.ChangeAntropologDateResponce;
import avangardteen.java2app.service.ChangeAntropometricDataService;

import java.util.List;
import java.util.Scanner;
@Component
public class ChangenAtropologDateUIAAction implements UIAction {
   @Autowired
   static ChangeAntropometricDataService servis;


    static Scanner scan = new Scanner(System.in);

    @Override
    public void execute() {

        int choose = Integer.parseInt(scan.nextLine());
        switch (choose) {
            case (1):
                System.out.println("введите новое значение ширины таза");
                break;
            case (2):
                System.out.println("введите новое значение длины бедра");
                break;
            case (3):
                System.out.println("введите новое значение длины спины до нижнего края лопатки");
                break;
            case (4):
                System.out.println("введите новое значение длины голени");
                break;
        }
        String meaning = scan.nextLine();
        ChangeAntropologDateRequest request = new ChangeAntropologDateRequest(choose, meaning);

        ChangeAntropologDateResponce responce = servis.responce(request);
        if (responce.hasErrors()) {
            List<CoreError> errors = responce.getErrorList();
            for (CoreError error : errors) {
                System.err.println(error.getLocation() + ": " + error.getMessage());}}
                System.out.println("Новое значение сохранено");

    }
}
