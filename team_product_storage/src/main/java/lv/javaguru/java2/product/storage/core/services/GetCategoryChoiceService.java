package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.domain.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class GetCategoryChoiceService {

    public Category getCategoryChoice(Scanner scanner, List<String> categories) {
        System.out.println("Enter the number corresponding to the desired category:");

        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= categories.size()) {
                    Category selectedCategory = Category.valueOf(categories.get(choice - 1));
                    System.out.println("You selected: " + selectedCategory);
                    return selectedCategory;
                } else {
                    System.out.println("Please enter a valid category number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid category number.");
                scanner.next();
            }
        }
    }
}
