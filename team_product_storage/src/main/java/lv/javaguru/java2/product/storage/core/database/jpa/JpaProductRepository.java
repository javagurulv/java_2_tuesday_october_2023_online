package lv.javaguru.java2.product.storage.core.database.jpa;

import lv.javaguru.java2.product.storage.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select * from products where product_brand = :productBrand", nativeQuery = true)
	List<Product> findByProductBrand(@Param("productBrand") String productBrand);

	@Query("SELECT p FROM Product p WHERE p.productBrand LIKE %:productBrand%")
	List<Product> findByProductBrandLike(@Param("productBrand") String productBrand);

	List<Product> findByProductModel(String productModel);

	@Query("SELECT p FROM Product p WHERE p.productModel LIKE %:productModel%")
	List<Product> findByProductModelLike(@Param("productModel") String productModel);

	List<Product> findByProductBrandAndProductModel(String productBrand, String productModel);

	@Query("SELECT p FROM Product p WHERE p.productBrand LIKE %:productBrand% AND p.productModel LIKE %:productModel%")
	List<Product> findByProductBrandAndProductModelLike(@Param("productBrand") String productBrand,
														@Param("productModel") String productModel);

}


