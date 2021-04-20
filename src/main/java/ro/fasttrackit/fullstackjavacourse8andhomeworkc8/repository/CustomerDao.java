package ro.fasttrackit.curs8.repository;

import org.springframework.stereotype.Repository;
import ro.fasttrackit.curs8.model.CustomerFilters;
import ro.fasttrackit.curs8.model.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
public class CustomerDao {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public List<Customer> getAll(CustomerFilters filters) {
        CriteriaQuery<Customer> criteria = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = criteria.from(Customer.class);

        List<Predicate> whereClause = new ArrayList<>();
        ofNullable(filters.getName())
                .ifPresent(name -> whereClause.add(criteriaBuilder.equal(root.get("name"), name)));
        ofNullable(filters.getAge())
                .ifPresent(minAge -> whereClause.add(criteriaBuilder.gt(root.get("age"), minAge)));
        CriteriaQuery<Customer> query = criteria.select(root).where(whereClause.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
