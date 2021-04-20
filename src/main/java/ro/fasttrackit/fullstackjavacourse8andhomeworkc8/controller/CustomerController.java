package ro.fasttrackit.curs8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs8.model.CustomerFilters;
import ro.fasttrackit.curs8.model.entity.Customer;
import ro.fasttrackit.curs8.model.entity.Review;
import ro.fasttrackit.curs8.service.CustomerService;
import ro.fasttrackit.curs8.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    private final ReviewService reviewService;

    @GetMapping
    List<Customer> getAll(CustomerFilters filters) {
        return service.getAll(filters);
    }

    @GetMapping("{customerId}/reviews")
    List<Review> getReviewsForCustomer(@PathVariable long customerId) {
        return reviewService.getReviewsForCustomer(customerId);
    }
}
