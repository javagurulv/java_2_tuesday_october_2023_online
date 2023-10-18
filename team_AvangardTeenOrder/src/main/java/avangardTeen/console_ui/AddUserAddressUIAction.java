package avangardTeen.console_ui;

import avangardTeen.services.AddUserAddressService;

import java.util.Scanner;

public class AddUserAddressUIAction {
    private AddUserAddressService serviceAddUserAddress;

    public AddUserAddressUIAction(AddUserAddressService serviceAddUserAddress) {
        this.serviceAddUserAddress = serviceAddUserAddress;
    }

    public void execute(AddUserAddressService serviceAddUserAddress) {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("введите фактический адрес проживания");
        String userAddress = scan2.nextLine();
        serviceAddUserAddress.addUserAddress(userAddress);
    }


}
