package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmCakeRepositoryImpl implements CakeRepository {

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(Cake cake) {
		sessionFactory.getCurrentSession().save(cake);
	}

	@Override
	public Optional<Cake> getById(Long id) {
		Cake cake = sessionFactory.getCurrentSession().get(Cake.class, id);
		if (cake == null) {
			return Optional.empty();
		} else {
			return Optional.of(cake);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Cake where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<Cake> getAllCakes() {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT c FROM Cake c", Cake.class)
				.getResultList();
	}

	@Override
	public List<Cake> findByCakeName(String cakeName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Cake c where cakeName = :cakeName");
		query.setParameter("cakeName", cakeName);
		return query.getResultList();
	}

	@Override
	public List<Cake> findByWeight(double weight) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Cake c where weight = :weight");
		query.setParameter("weight", weight);
		return query.getResultList();
	}

	@Override
	public List<Cake> findByCakeNameAndWeight(String cakeName, double weight) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Cake c where cakeName = : cakeName AND weight = :weight");
		query.setParameter("cakeName", cakeName);
		query.setParameter("weight", weight);
		return query.getResultList();
	}
}
