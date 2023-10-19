package avangardteen.java.UIAction;


import avangardteen.java.UserSizes;
import avangardteen.java.Wheelchair;
import avangardteen.java.service.ChooseAntropometricDataServis;
import java.util.Scanner;

public class ChooseAnthropometricDataIUActiv {

    Scanner scan = new Scanner(System.in);
    ChooseAntropometricDataServis servis;

    public ChooseAnthropometricDataIUActiv(ChooseAntropometricDataServis servis) {
        this.servis = servis;
    }

    public void execute(Wheelchair wheelchair) {
        pelwicWidth();
        thighLength();
        backLength();
        shinLength();
    }
    private void shinLength() {
        System.out.println("введите длину голени пользователя");
        int shinLength = scan.nextInt();
        servis.setShinLength(shinLength);

    }

    private void backLength() {
        System.out.println("введите длину спины пользователя до нижнего края лопатки");
        int backLength = scan.nextInt();
       servis.setBackLength(backLength);
    }

    private void thighLength() {
        System.out.println("введите длину бедра пользователя");
        int thighLength = scan.nextInt();
        servis.setThighLength(thighLength);
    }

    private void pelwicWidth() {
        System.out.println("введите ширину таза пользователя");
        int pelwicWidth = scan.nextInt();
        servis.setPelvis(pelwicWidth);
    }
}
