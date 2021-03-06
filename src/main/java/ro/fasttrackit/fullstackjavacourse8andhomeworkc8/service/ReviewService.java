package ro.fasttrackit.fullstackjavacourse8andhomeworkc8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.fullstackjavacourse8andhomeworkc8.model.entity.Review;
import ro.fasttrackit.fullstackjavacourse8andhomeworkc8.repository.ReviewRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;
    public List<Review> getReviewsForCustomer(long customerId) {
        return repository.findByCustomerId(customerId);
    }
}
