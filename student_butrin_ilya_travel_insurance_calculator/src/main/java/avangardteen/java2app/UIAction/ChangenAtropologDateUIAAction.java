package avangardteen.java2app.UIAction;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.request.ShowDataSizeRequest;
import avangardteen.java2app.responce.ShowDataSizeResponse;
import avangardteen.java2app.service.GetAntropometricDataServis;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChangeAntropologDateRequest;
import avangardteen.java2app.responce.ChangeAntropologDateResponce;
import avangardteen.java2app.service.ChangeAntropometricDataService;

import java.util.List;
import java.util.Scanner;
@Component
public class ChangenAtropologDateUIAAction implements UIAction {
   @Autowired ChangeAntropometricDataService changeServis;
   @Autowired ShowDataSizeUIActive showDataSizeUIActive;
    static Scanner scan = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Какой параметр хотите изменить?");
        showDataSizeUIActive.execute();
        System.out.println();
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

        ChangeAntropologDateResponce responce = changeServis.responce(request);
        if (responce.hasErrors()) {
            List<CoreError> errors = responce.getErrorList();
            for (CoreError error : errors) {
                System.err.println(error.getLocation() + ": " + error.getMessage());}}
                System.out.println("Новое значение сохранено");

    }
}
