package avangardTeen.console_ui;

import avangardTeen.services.AddPhoneNumberService;

import java.util.Scanner;

public class AddPhoneNumberUIAction {
    private AddPhoneNumberService serviceAddPhoneNumber;

    public AddPhoneNumberUIAction(AddPhoneNumberService serviceAddPhoneNumber) {
        this.serviceAddPhoneNumber = serviceAddPhoneNumber;
    }

    public void execute(AddPhoneNumberService serviceAddPhoneNumber) {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("введите номер телефона");
        String phoneNumber = scan2.nextLine();
        serviceAddPhoneNumber.addPhoneNumber(phoneNumber);
    }


}
