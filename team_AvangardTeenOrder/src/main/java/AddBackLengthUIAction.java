import java.util.Scanner;

public class AddBackLengthUIAction {

    private AddBackLengthService serviceAddBackLength;

    public AddBackLengthUIAction(AddBackLengthService serviceAddBackLength) {
        this.serviceAddBackLength = serviceAddBackLength;
    }

    public void execute(AddBackLengthService serviceAddBackLength) {
        System.out.println("введите длину спины пользователя до нижнего края лопатки");
        Scanner scan = new Scanner(System.in);
        int backLength = scan.nextInt();
        serviceAddBackLength.addBackLength(backLength);
    }


}
