package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProductsService {

    private Database database;
    private SearchProductsRequestValidator validator;

    public SearchProductsService(Database database,
                                 SearchProductsRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchProductsResponse execute(SearchProductsRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchProductsResponse(null, errors);
        }

        List<Product> products = search(request);
        products = order(products, request.getOrdering());
        products = paging(products, request.getPaging());

        return new SearchProductsResponse(products, null);
    }

    private List<Product> order(List<Product> products, Ordering ordering) {
        if (ordering != null) {
            Comparator<Product> comparator = ordering.getOrderBy().equals("productBrand")
                    ? Comparator.comparing(Product::getProductBrand)
                    : Comparator.comparing(Product::getProductModel);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return products.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return products;
        }
    }

    private List<Product> search(SearchProductsRequest request){
        List<Product> products = new ArrayList<>();
        if (request.isProductBrandProvided() && !request.isProductModelProvided()) {
            products = database.findByProductBrand(request.getProductBrand());
        }
        if (!request.isProductBrandProvided() && request.isProductModelProvided()) {
            products = database.findByProductBrand(request.getProductBrand());
        }
        if (request.isProductBrandProvided() && request.isProductModelProvided()) {
            products = database.findByProductBrandAndProductModel(request.getProductBrand(), request.getProductModel());
        }

        return products;
    }

    private List<Product> paging(List<Product> products, Paging paging) {
        if (paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return products.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return products;
        }
    }
}
