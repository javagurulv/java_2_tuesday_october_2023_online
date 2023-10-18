package avangardTeen.console_ui;

import avangardTeen.services.AddThighLengthService;

import java.util.Scanner;

public class AddThighLengthUIAction {

    private AddThighLengthService serviceAddThighLength;

    public AddThighLengthUIAction(AddThighLengthService serviceAddThighLength) {
        this.serviceAddThighLength = serviceAddThighLength;
    }

    public void execute(AddThighLengthService serviceAddThighLength) {
        System.out.println("введите длину бедра пользователя");
        Scanner scan = new Scanner(System.in);
        int thighLength = scan.nextInt();
        serviceAddThighLength.addThighLength(thighLength);
    }

}
