package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class GetGenreChoice {

    public Genre getGenreChoice(Scanner scanner, List<String> genres) {
        System.out.println("Enter the name corresponding to the desired genre:");

        String selectedGenreName = null;
        while (true) {
            try {
                selectedGenreName = scanner.nextLine();
                if (genres.contains(selectedGenreName)) {
                    Genre selectedGenre = Genre.valueOf(selectedGenreName.toUpperCase());
                    System.out.println("You selected: " + selectedGenre);
                    return selectedGenre;
                } else {
                    System.out.println("Please enter a valid genre name.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid genre name.");
            }
        }
    }
}
