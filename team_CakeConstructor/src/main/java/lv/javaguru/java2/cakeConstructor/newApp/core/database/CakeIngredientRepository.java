package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.CakeIngredient;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CakeIngredientRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(CakeIngredient cakeIngredient) {
		sessionFactory.getCurrentSession().save(cakeIngredient);
	}

	public CakeIngredient getById(Long id) {
		return sessionFactory.getCurrentSession()
				.get(CakeIngredient.class, id);
	}

	public List<CakeIngredient> getAllCakeIngredients(Cake cake) {
		Query<CakeIngredient> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT ci FROM CakeIngredient ci where ci.cake = :cake", CakeIngredient.class);
		query.setParameter("cake", cake);
		return query.getResultList();
	}

}
