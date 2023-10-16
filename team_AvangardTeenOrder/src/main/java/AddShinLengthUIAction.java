import java.util.Scanner;

public class AddShinLengthUIAction {

    private AddShinLengthService serviceAddShinLength;

    public AddShinLengthUIAction(AddShinLengthService serviceAddShinLength) {
        this.serviceAddShinLength = serviceAddShinLength;
    }

    public void execute(AddShinLengthService serviceAddShinLength) {
        System.out.println("введите длину голени пользователя");
        Scanner scan = new Scanner(System.in);
        int shinLength = scan.nextInt();
        serviceAddShinLength.addShinLength(shinLength);
    }


}
