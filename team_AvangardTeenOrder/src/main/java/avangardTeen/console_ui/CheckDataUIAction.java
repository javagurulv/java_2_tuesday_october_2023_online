package avangardTeen.console_ui;

import avangardTeen.services.CheckDataService;

public class CheckDataUIAction {
  private CheckDataService serviceCheckData;

    public CheckDataUIAction(CheckDataService serviceCheckData) {
        this.serviceCheckData = serviceCheckData;
    }

    public void execute(CheckDataService serviceCheckData) {
        System.out.println("Ваши параметры: ");
        System.out.println("ширина таза:  " + serviceCheckData.checkPelvisWidth());
        System.out.println("длина бедра: " + serviceCheckData.checkThighLength());
        System.out.println("длина спины до нижнего края лопатки: " + serviceCheckData.checkBackLengt());
        System.out.println("длину голени: " + serviceCheckData.checkShinLength());
        System.out.println("Нажмите \"ок\", чтобы сохранить данные");


   }

}
