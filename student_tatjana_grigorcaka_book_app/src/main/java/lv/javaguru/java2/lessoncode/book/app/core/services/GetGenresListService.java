package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetGenresListService {

    public List<String> getGenresList() {
        List<String> genres = Arrays.stream(Genre.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i + 1) + ". " + genres.get(i));
        }

        return genres;
    }
}
