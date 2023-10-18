package avangardTeen.console_ui;

import avangardTeen.services.ShowPersonalDateToCheckService;

public class ShowPersonalDateToCheckUIAction {
  private ShowPersonalDateToCheckService serviceCheckData;

    public ShowPersonalDateToCheckUIAction(ShowPersonalDateToCheckService serviceCheckData) {
        this.serviceCheckData = serviceCheckData;
    }

    public void execute(ShowPersonalDateToCheckService serviceCheckData) {
        System.out.println("проверьте введенные данные: ");
        System.out.println("Имя, Фамилия:  " + serviceCheckData.checkUserName());
        System.out.println("номер телефона: " + serviceCheckData.checkUserPhone());
        System.out.println("фактический адрес проживания: " + serviceCheckData.checkUserAddress());


   }

}
