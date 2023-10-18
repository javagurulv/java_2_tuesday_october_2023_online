package avangardTeen;

import avangardTeen.domain.UserData;

public class TestAPP {
    public static void main(String[] args) {
        UserSizes userSize1 = new UserSizes(31,31,40, 34);
        UserData userData1 = new UserData("Maikle Konnely", "1234567", "Riga, Rigas1-1");
        System.out.println("Ширина сиденья = " + userSize1.findSeatWidth() + " cm");
        System.out.println("Глубина сиденья = " + userSize1.findSeatDepth() + " cm");
        System.out.println("Высота спинки = " + userSize1.backHeight + " cm");
        System.out.println("Длина подножки = MB " + userSize1.findFootrestLength());
        System.out.println("Имя, Фамилия: " + userData1.getNameSurname());
        System.out.println("Телефон: " + userData1.getPhoneNumber());
        System.out.println("Адрес: " + userData1.getUserAddress());



    }
}
