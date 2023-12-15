package lv.javaguru.java2.lessoncode.book.app.console_ui;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class GetGenreChoice {

    public String getGenreChoice(Scanner scanner, List<String> genres) {
        System.out.println("Enter the name corresponding to the desired genre:");

        String selectedGenreName = null;
        while (true) {
            try {
                selectedGenreName = scanner.nextLine();
                if (genres.contains(selectedGenreName)) {
                    System.out.println("You selected: " + selectedGenreName);
                    return selectedGenreName;
                } else {
                    System.out.println("Please enter a valid genre name.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid genre name.");
            }
        }
    }
}
