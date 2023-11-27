package avangardteen.java2app.UIAction;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChangeComponentsRequest;
import avangardteen.java2app.responce.ChangeCompanentsResponce;
import avangardteen.java2app.service.ChangeComponentServise;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
@Component
public class ChangeComponentUIAction implements UIAction {
   @Autowired
   ChangeComponentServise servise;

    Scanner scan = new Scanner(System.in);

    @Override
    public void execute() {
        ChangeCompanentsResponce responce = servise.responce();
        System.out.println("Какой параметр хотите изменить?");
        showAllComponent(responce);
        int cathegory = scan.nextInt();
        ChangeComponentsRequest request = new ChangeComponentsRequest(cathegory);
        boolean err;
        err = true;
        System.out.println("выберите новое значение параметра " + responce.getListAllCategory().get(cathegory - 1));
        ChangeCompanentsResponce responce2 = servise.responce2(request);
        for (int i = 0; i < responce2.getChooseNewComponent().size(); i++) {
            System.out.println(i + 1 + ". " + responce2.getChooseNewComponent().get(i).getInformation() + " цена: " + responce2.getChooseNewComponent().get(i).getPrice());
        }
        int newChoose = scan.nextInt();
        ChangeComponentsRequest request2 = new ChangeComponentsRequest(cathegory, newChoose);
        ChangeCompanentsResponce responce3 = servise.responce3(request2);
        if (responce3.hasErrors()) {
            err = false;
            List<CoreError> errors = responce3.getErrorList();
            for (CoreError error : errors) {
                System.err.println(error.getLocation() + ": " + error.getMessage());
                if (error.getLocation().equals("Заднии колеса")) {
                    System.out.println("выберите новое значение параметра колеса:");
                    List<ComponentWheelchair> xxx = servise.responce4();
                    for (int i = 0; i < xxx.size(); i++) {
                        System.out.println(i+1 +". " + xxx.get(i).getInformation());
                    }
                    int newChoose2 = scan.nextInt();
                    ChangeComponentsRequest request4 = new ChangeComponentsRequest(0, newChoose2);
                     servise.responce5(request4);
                }

            }
        }
    }




        public  void showAllComponent(ChangeCompanentsResponce response) {
            response.getListAllCategory();
            int i = 0;
            for (Map.Entry<Category, ComponentWheelchair> component : response.getWheelchair().getComponents().entrySet()) {
                i++;
                System.out.println(i + ". " +
                        component.getKey() + ": " +
                        component.getValue().getInformation() + ". Цена: " +
                        component.getValue().getPrice());
            }

    }
}
