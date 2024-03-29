package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAllProductsService {

    @Autowired
    private JpaProductRepository productRepository;

    public GetAllProductsResponse execute(GetAllProductsRequest request) {
        List<Product> products = productRepository.findAll();
        return new GetAllProductsResponse(products);
    }
}
