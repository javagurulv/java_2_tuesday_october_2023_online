package avangardteen.java.UIAction;

import avangardteen.java.CoreError;
import avangardteen.java.request.ChangeAntropologDateRequest;
import avangardteen.java.responce.ChangeAntropologDateResponce;
import avangardteen.java.service.ChangeAntropometricDataService;

import java.util.List;
import java.util.Scanner;

public class ChangenAtropologDateUIAAction implements UIAction {
    static ChangeAntropometricDataService servis;

    public ChangenAtropologDateUIAAction(
            ChangeAntropometricDataService servis) {
        this.servis = servis;
    }

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

        ChangeAntropologDateResponce responce = servis.response(request);
        if (responce.hasErrors()) {
            List<CoreError> errors = responce.getErrorList();
            for (CoreError error : errors) {
                System.err.println(error.getLocation() + ": " + error.getMessage());}}
                System.out.println("Новое значение сохранено");

    }
}
