package lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCakeRepository extends JpaRepository<Cake, Long> {

    @Query(value = "SELECT SUM(ci.quantity) AS weight FROM cake_constructor.cakes c INNER JOIN cake_constructor.cake_ingredients ci ON c.id = ci.cake_id WHERE ci.cake_id = :cakeId", nativeQuery = true)
    Double sumWeight(@Param("cakeId") Long id);


    @Query(value = "select * from cakes where cakeName = :cakeName", nativeQuery = true)
    List<Cake> findByCakeName(@Param("cakeName") String cakeName);

    @Query("SELECT c FROM Cake c WHERE c.cakeName LIKE %:cakeName%")
    List<Cake> findByCakeNameLike(@Param("cakeName") String cakeName);

    List<Cake> findByWeight(Double weight);

    @Query("SELECT c FROM Cake c WHERE c.weight LIKE %:weight%")
    List<Cake> findByWeightLike(@Param("weight") Double weight);

    List<Cake> findByCakeNameAndWeight(String cakeName, Double weight);

    @Query("SELECT c FROM Cake c WHERE c.cakeName LIKE %:cakeName% AND c.weight LIKE %:weight%")
    List<Cake> findByCakeNameAndWeightLike(@Param("cakeName") String cakeName,
                                            @Param("weight") Double weight);

}
