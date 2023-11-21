package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.SearchIngredientsRequestValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchIngredientsService {

    private Database database;
    private SearchIngredientsRequestValidator validator;

    public SearchIngredientsService(Database database,
                                    SearchIngredientsRequestValidator validation){
        this.database=database;
        this.validator=validation;
    }

    public SearchIngredientsResponse execute(SearchIngredientsRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchIngredientsResponse(null, errors);
        }

        List<Ingredient> ingredients = search(request);
        ingredients = order(ingredients, request.getOrdering());
        ingredients = paging(ingredients, request.getPaging());

        return new SearchIngredientsResponse(ingredients, null);
    }

    private List<Ingredient> order (List<Ingredient> ingredients, Ordering ordering) {
        if (ordering != null) {
            Comparator<Ingredient> comparator = ordering.getOrderBy().equals("type")
                    ? Comparator.comparing(Ingredient::getType)
                    : Comparator.comparing(Ingredient::getTaste);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return ingredients.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return ingredients;
        }
    }
    private List<Ingredient> search(SearchIngredientsRequest request) {
        List<Ingredient> ingredients = new ArrayList<>();
        if (request.isTypeProvided() && !request.isTasteProvided()) {
            ingredients = database.findByType(request.getType());
        }
        if (!request.isTypeProvided() && request.isTasteProvided()) {
            ingredients = database.findByTaste(request.getTaste());
        }
        if (request.isTypeProvided() && request.isTasteProvided()) {
            ingredients = database.findByTypeAndTaste(request.getType(), request.getTaste());
        }
        return ingredients;
    }

    private List<Ingredient> paging(List<Ingredient> ingredients, Paging paging) {
        if (paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return ingredients.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return ingredients;
        }
    }

}
