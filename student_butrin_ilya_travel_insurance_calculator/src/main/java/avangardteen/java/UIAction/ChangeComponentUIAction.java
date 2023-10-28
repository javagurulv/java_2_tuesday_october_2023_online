package avangardteen.java.UIAction;

import avangardteen.java.Category;
import avangardteen.java.Component;
import avangardteen.java.request.ChangeComponentsRequest;
import avangardteen.java.responce.ChangeCompanentsResponce;
import avangardteen.java.service.ChangeComponentServise;

import java.util.Map;
import java.util.Scanner;

public class ChangeComponentUIAction implements UIAction {
ChangeComponentServise servise;

    public ChangeComponentUIAction(ChangeComponentServise servise) {
        this.servise = servise;
    }

    Scanner scan = new Scanner(System.in);

    @Override
    public void execute () {
        ChangeCompanentsResponce responce = servise.responce();
        System.out.println("Какой параметр хотите изменить?");
        showAllComponent(responce);
        int cathegory = scan.nextInt();
        ChangeComponentsRequest request = new ChangeComponentsRequest(cathegory);
        System.out.println("выберите новое значение параметра " + responce.getListAllCategory().get(cathegory - 1));
        ChangeCompanentsResponce responce2 = servise.responce2(request);
        for (int i = 0; i < responce2.getChooseNewComponent().size(); i++) {
            System.out.println(i + 1 + ". " + responce2.getChooseNewComponent().get(i).getInformation() + " цена: " + responce2.getChooseNewComponent().get(i).getPrice());
        }
        int newChoose = scan.nextInt();
        ChangeComponentsRequest request2 = new ChangeComponentsRequest(cathegory, newChoose);
        ChangeCompanentsResponce responce3 = servise.responce3(request2);





    }




        public  void showAllComponent(ChangeCompanentsResponce response) {
            response.getListAllCategory();
            int i = 0;
            for (Map.Entry<Category, Component> component : response.getClient().getWheelchair().getComponents().entrySet()) {
                i++;
                System.out.println(i + ". " +
                        component.getKey() + ": " +
                        component.getValue().getInformation() + ". Цена: " +
                        component.getValue().getPrice());
            }

    }
}
