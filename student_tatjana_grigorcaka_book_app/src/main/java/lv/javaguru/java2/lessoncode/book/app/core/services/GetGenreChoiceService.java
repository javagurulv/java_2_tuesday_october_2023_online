package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class GetGenreChoiceService {

    public Genre getGenreChoice(Scanner scanner, List<String> genres) {
        System.out.println("Enter the number corresponding to the desired genre:");

        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= genres.size()) {
                    Genre selectedGenre = Genre.valueOf(genres.get(choice - 1));
                    System.out.println("You selected: " + selectedGenre);
                    return selectedGenre;
                } else {
                    System.out.println("Please enter a valid genre number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid genre number.");
                scanner.next();
            }
        }
    }
}
