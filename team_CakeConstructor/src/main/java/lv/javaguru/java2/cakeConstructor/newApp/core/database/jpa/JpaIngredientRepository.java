package lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaIngredientRepository extends JpaRepository<Ingredient, Long> {

	@Query(value = "select * from ingredients where type = :type", nativeQuery = true)
	List<Ingredient> findByType(@Param("type") String type);

	@Query("SELECT i FROM Ingredient i WHERE i.type LIKE %:type%")
	List<Ingredient> findByTypeLike(@Param("type") String type);

	List<Ingredient> findByTaste(String taste);

	@Query("SELECT i FROM Ingredient i WHERE i.taste LIKE %:taste%")
	List<Ingredient> findByTasteLike(@Param("taste") String taste);

	List<Ingredient> findByTypeAndTaste(String type, String taste);

	@Query("SELECT i FROM Ingredient i WHERE i.type LIKE %:type% AND i.taste LIKE %:taste%")
	List<Ingredient> findByTypeAndTasteLike(@Param("type") String type,
											@Param("taste") String taste);

}



