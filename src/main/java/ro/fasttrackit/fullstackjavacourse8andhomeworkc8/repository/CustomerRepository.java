package ro.fasttrackit.curs8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.fasttrackit.curs8.model.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContainingAndAddressCityIn(String name, List<String> city);

    List<Customer> findByAgeGreaterThan(int age);

    @Query("select c from Customer c where c.age>=:age")
    List<Customer> findMajorPersonsJPQL(int age);

    @Query(value = "select * from customer where age>=:age", nativeQuery = true)
    List<Customer> findPersonsSQL(int age);
}
