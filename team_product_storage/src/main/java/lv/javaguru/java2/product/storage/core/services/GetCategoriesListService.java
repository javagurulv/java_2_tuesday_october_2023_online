package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.domain.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetCategoriesListService {

    public List<String> getCategoriesList() {
        List<String> categories = Arrays.stream(Category.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }

        return categories;
    }
}
