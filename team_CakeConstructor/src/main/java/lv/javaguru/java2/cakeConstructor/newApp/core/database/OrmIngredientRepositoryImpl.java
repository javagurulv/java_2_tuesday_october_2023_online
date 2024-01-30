package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmIngredientRepositoryImpl implements IngredientRepository {

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(Ingredient ingredient) {
		sessionFactory.getCurrentSession().save(ingredient);
	}

	@Override
	public Optional<Ingredient> getById(Long id) {
		Ingredient ingredient = sessionFactory.getCurrentSession().get(Ingredient.class, id);
		if (ingredient == null) {
			return Optional.empty();
		} else {
			return Optional.of(ingredient);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Ingredient where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT i FROM Ingredient i", Ingredient.class)
				.getResultList();
	}

	@Override
	public List<Ingredient> findByType(String type) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select i FROM Ingredient i where type = :type");
		query.setParameter("type", type);
		return query.getResultList();
	}

	@Override
	public List<Ingredient> findByTaste(String taste) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select i FROM Ingredient i where taste = :taste");
		query.setParameter("taste", taste);
		return query.getResultList();
	}

	@Override
	public List<Ingredient> findByTypeAndTaste(String type, String taste) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select i FROM Ingredient i where type = :type AND taste = :taste");
		query.setParameter("type", type);
		query.setParameter("taste", taste);
		return query.getResultList();
	}
}
