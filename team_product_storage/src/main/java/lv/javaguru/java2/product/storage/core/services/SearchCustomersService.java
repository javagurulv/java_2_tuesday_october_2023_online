package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.CustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.SearchCustomersResponse;
import lv.javaguru.java2.product.storage.core.services.validators.SearchCustomersRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SearchCustomersService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired private CustomerRepository customerRepository;
    @Autowired private SearchCustomersRequestValidator validator;


    public SearchCustomersResponse execute(SearchCustomersRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchCustomersResponse(null, errors);
        }

        List<Customer> customers = search(request);
        customers = order(customers, request.getOrdering());
        customers = paging(customers, request.getPaging());

        return new SearchCustomersResponse(customers, null);
    }

    private List<Customer> order(List<Customer> customers, Ordering ordering) {
        if (orderingEnabled && (ordering != null)) {
            Comparator<Customer> comparator = ordering.getOrderBy().equals("customerName")
                    ? Comparator.comparing(Customer::getCustomerName)
                    : Comparator.comparing(Customer::getRegistrationCode);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return customers.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return customers;
        }
    }

    private List<Customer> search(SearchCustomersRequest request) {
        List<Customer> customers = new ArrayList<>();
        if (request.isCustomerNameProvided() && !request.isRegistrationCodeProvided()) {
            customers = customerRepository.findByCustomerName(request.getCustomerName());
        }
        if (!request.isCustomerNameProvided() && request.isRegistrationCodeProvided()) {
            customers = customerRepository.findByRegistrationCode(request.getRegistrationCode());
        }
        if (request.isCustomerNameProvided() && request.isRegistrationCodeProvided()) {
            customers = customerRepository.findByCustomerNameAndRegistrationCode(request.getCustomerName(), request.getRegistrationCode());
        }
        return customers;
    }

    private List<Customer> paging(List<Customer> customers, Paging paging) {
        if (pagingEnabled && (paging != null)) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return customers.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            System.out.println("paging test");
            return customers;

        }
    }
}
