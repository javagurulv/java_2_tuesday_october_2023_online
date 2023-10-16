import java.util.Scanner;

public class AddNameSurnameUIAction {
    private AddNameSurnameService serviceAddNameSurname;

    public AddNameSurnameUIAction(AddNameSurnameService serviceAddNameSurname) {
        this.serviceAddNameSurname = serviceAddNameSurname;

    }

    public void execute(AddNameSurnameService serviceNameSurname) {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("введите Имя, Фамилия");
        String nameSurname = scan2.nextLine();
        serviceNameSurname.addNameSurname(nameSurname);
    }



}
