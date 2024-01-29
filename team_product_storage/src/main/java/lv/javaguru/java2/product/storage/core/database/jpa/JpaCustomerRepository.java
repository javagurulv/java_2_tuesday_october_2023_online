package lv.javaguru.java2.product.storage.core.database.jpa;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByCustomerName(String customerName);

    @Query("SELECT c FROM Customer c WHERE c.customerName LIKE %:customerName%")
    List<Customer> findByCustomerNameLike(@Param("customerName") String customerName);

    @Query(value = "select * from customers where registration_code = :registrationCode", nativeQuery = true)
    List<Customer> findByRegistrationCode(@Param("registrationCode") String registrationCode);

    @Query("SELECT c FROM Customer c WHERE c.registrationCode LIKE %:registrationCode%")
    List<Customer> findByRegistrationCodeLike(@Param("registrationCode") String registrationCode);

    List<Customer> findByCustomerNameAndRegistrationCode(String customerName, String registrationCode);

    @Query("SELECT c FROM Customer c WHERE c.customerName LIKE %:customerName% AND c.registrationCode LIKE %:registrationCode")
    List<Customer> findByCustomerNameAndRegistrationCodeLike(@Param("customerName") String customerName,
                                                             @Param("registrationCode") String registrationCode);


}
