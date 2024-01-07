package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class OrmProductRepositoryImpl implements ProductRepository {

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public Optional<Product> getById(Long id) {
		Product product = sessionFactory.getCurrentSession().get(Product.class, id);
		if (product == null) {
			return Optional.empty();
		} else {
			return Optional.of(product);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Product where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT p FROM Product p", Product.class)
				.getResultList();
	}

	@Override
	public List<Product> findByProductBrand(String productBrand) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select p FROM Product p where productBrand = :productBrand");
		query.setParameter("productBrand", productBrand);
		return query.getResultList();
	}

	@Override
	public List<Product> findByProductModel(String productModel) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select p FROM Product p where productModel = :productModel");
		query.setParameter("productModel", productModel);
		return query.getResultList();
	}

	@Override
	public List<Product> findByProductBrandAndProductModel(String productBrand, String productModel) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select p FROM Product p where productBrand = : productBrand AND productModel = :productModel");
		query.setParameter("productBrand", productBrand);
		query.setParameter("productModel", productModel);
		return query.getResultList();
	}
}
