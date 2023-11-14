package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.SearchIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngridientResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchIngridientsService {

    private DatabaseImpl database;
    private SearchIngridientRequestValidation validation;

    public SearchIngridientsService (DatabaseImpl database, SearchIngridientRequestValidation validation){
        this.database=database;
        this.validation=validation;
    }

    public SearchIngridientResponse execute(SearchIngridientRequest request) {
        List<CoreError> errors = validation.validation(request);
        if (!errors.isEmpty()) {
            return new SearchIngridientResponse(null, errors);
        }

        List<Ingridient> ingridients = null;
        if (request.isTypeProvided() && !request.isTasteProvided()) {
            ingridients = database.findByType(request.getTypeOfIngridient());
        }
        if (!request.isTypeProvided() && request.isTasteProvided()) {
            ingridients = database.findByTaste(request.getTasteOfIngridient());
        }
        if (request.isTypeProvided() && request.isTasteProvided()) {
            ingridients = database.findByTypeAndTaste(request.getTypeOfIngridient(), request.getTasteOfIngridient());
        }

        return new SearchIngridientResponse(ingridients, null);
    }

    private List<Ingridient> order (List<Ingridient> ingridients, Ordering ordering) {
        if (ordering != null) {
            Comparator<Ingridient> comparator = ordering.getOrderBy().equals("type")
                    ? Comparator.comparing(Ingridient::getType)
                    : Comparator.comparing(Ingridient::getTaste);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return ingridients.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return ingridients;
        }
    }
    private List<Ingridient> search(SearchIngridientRequest request) {
        List<Ingridient> ingridients = new ArrayList<>();
        if (request.isTypeProvided() && !request.isTasteProvided()) {
            ingridients = database.findByType(request.getTypeOfIngridient());
        }
        if (!request.isTypeProvided() && request.isTasteProvided()) {
            ingridients = database.findByTaste(request.getTasteOfIngridient());
        }
        if (request.isTypeProvided() && request.isTasteProvided()) {
            ingridients = database.findByTypeAndTaste(request.getTypeOfIngridient(), request.getTasteOfIngridient());
        }
        return ingridients;
    }

    private List<Ingridient> paging(List<Ingridient> ingridients, Paging paging) {
        if (paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return ingridients.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return ingridients;
        }
    }

}
