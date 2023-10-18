package avangardteen.java.service;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.data.DataComponents;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChangeComponentServise {
    DataComponents components;
    Client client;

    public ChangeComponentServise(DataComponents components, Client client) {
        this.components = components;
        this.client = client;
    }

    public List<Category> listAllCategory() {
        List<Category> showCategory = new ArrayList<>();
        int number = 0;
        for (Map.Entry<Category, Component> component : client.getWheelchair().getComponents().entrySet()) {
            number++;
            showCategory.add(component.getValue().getCategory());

        }
        return showCategory;
    }
    public  void showAllComponent() {
        List<Category> showCategory = listAllCategory();
        int i = 0;
        for (Map.Entry<Category, Component> component : client.getWheelchair().getComponents().entrySet()) {
            i++;
            System.out.println(i + ". " +
                    component.getKey() + ": " +
                    component.getValue().getInformation() + ". Цена: " +
                    component.getValue().getPrice());
        }
    }
    public  void chooseNewComponent() {
        Scanner scanner = new Scanner(System.in);
        List<Category> showCategory = listAllCategory();
        int value = scanner.nextInt();
        System.out.println("выберите новое значение параметра " + showCategory.get(value - 1));
        List<Component> newChoose = new ArrayList<>();
        for (int i = 0; i < components.getAllComponents().size(); i++) {
            if (showCategory.get(value - 1).equals(components.getAllComponents().get(i).getCategory())) {
                newChoose.add(components.getAllComponents().get(i));
            }
        }
        for (int i = 0; i < newChoose.size(); i++) {
            System.out.println(i + 1 + ". " + newChoose.get(i).getInformation() + " цена: " + newChoose.get(i).getPrice());
        }
        int choose = scanner.nextInt();
        for (int i = 1; i <= newChoose.size(); i++) {
            if (choose == i) {
                String id = newChoose.get(i - 1).getComponentID();
                client.getWheelchair().addComponents(id, components);
            }
        }
    }
}
