package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DIComponent
public class InMemoryDatabaseImpl implements Database {
    private Long nextId = 1L;
    List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        product.setId(nextId);
        nextId++;
        products.add(product);
    }
    @Override
    public boolean deleteById(Long id) {
        boolean isProductDeleted = false;
        Optional<Product> productToDeleteOpt = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
        if (productToDeleteOpt.isPresent()) {
            Product productToRemove = productToDeleteOpt.get();
            isProductDeleted = products.remove(productToRemove);
        }
        return isProductDeleted;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }


    @Override
    public List<Product> findByProductName(String productName) {
        return products.stream()
                .filter(product -> product.getProductName().equals(productName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByProductBrand(String productBrand) {
        return products.stream()
                .filter(product -> product.getProductBrand().equals(productBrand))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByProductModel(String productModel) {
        return products.stream()
                .filter(product -> product.getProductModel().equals(productModel))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByProductBrandAndProductModel(String productBrand, String productModel) {
        return products.stream()
                .filter(product -> product.getProductBrand().equals(productBrand))
                .filter(product -> product.getProductModel().equals(productModel))
                .collect(Collectors.toList());
    }

}
