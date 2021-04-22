package ro.fasttrackit.fullstackjavacourse8andhomeworkc8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.fullstackjavacourse8andhomeworkc8.model.entity.Review;


import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCustomerId(long customerId);
}
