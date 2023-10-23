package avangardteen.java.UIAction;

import avangardteen.java.service.AddAtropologDateServis;

import java.util.Scanner;

public class ChangenAtropologDateUIAAction implements UIAction{
    static AddAtropologDateServis servis;

    public ChangenAtropologDateUIAAction(
            AddAtropologDateServis servis) {
        this.servis = servis;
    }

    static Scanner scan = new Scanner(System.in);
    @Override
    public void execute() {

        int choose = scan.nextInt();
        switch (choose) {
            case (1):
                adjustpelwicWidth();
                break;
            case (2):
                adjustThighLength();
                break;
            case (3):
                adjustBackLength();
                break;
            case (4):
                adjustShinLength();
                break;
        }
    }
    public static void adjustShinLength ()  {
        System.out.println("введите новое значение длины голени");
        int newShinLength = scan.nextInt();
        servis.setShinLength(newShinLength);
        System.out.println("Новое значение сохранено");
    }

    public static void adjustBackLength() {
        System.out.println("введите новое значение длины спины до нижнего края лопатки");
        int newBackLength = scan.nextInt();
        servis.setBackLength(newBackLength);
        System.out.println("Новое значение сохранено");
    }

    public static void adjustThighLength() {
        System.out.println("введите новое значение длины бедра");
        int newThighLength = scan.nextInt();
        servis.setThighLength(newThighLength);
        System.out.println("Новое значение сохранено");
    }

    public static void adjustpelwicWidth() {
        System.out.println("введите новое значение ширины таза");
        int newPelwicWidth = scan.nextInt();
        servis.setPelvis(newPelwicWidth);
        System.out.println("Новое значение сохранено");
    }

}
