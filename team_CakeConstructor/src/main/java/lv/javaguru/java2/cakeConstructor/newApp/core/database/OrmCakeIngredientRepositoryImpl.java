package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.CakeIngredient;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmCakeIngredientRepositoryImpl implements CakeIngredientRepository{

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(CakeIngredient cakeIngredient) {
		sessionFactory.getCurrentSession().save(cakeIngredient);
	}

	@Override
	public Optional<CakeIngredient> getById(Long id) {
		CakeIngredient cakeIngredient = sessionFactory.getCurrentSession().get(CakeIngredient.class, id);
		if (cakeIngredient == null) {
			return Optional.empty();
		} else {
			return Optional.of(cakeIngredient);
		}
	}
	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete CakeIngredient where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<CakeIngredient> getAllCakeIngredients(Cake cake) {
		Query<CakeIngredient> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT ci FROM CakeIngredient ci where ci.cake = :cake", CakeIngredient.class);
		query.setParameter("cake", cake);
		return query.getResultList();
	}

}
