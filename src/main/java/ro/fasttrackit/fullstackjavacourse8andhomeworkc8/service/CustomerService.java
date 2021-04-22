package ro.fasttrackit.fullstackjavacourse8andhomeworkc8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.fullstackjavacourse8andhomeworkc8.model.CustomerFilters;
import ro.fasttrackit.fullstackjavacourse8andhomeworkc8.model.entity.Customer;
import ro.fasttrackit.fullstackjavacourse8andhomeworkc8.repository.CustomerDao;
import ro.fasttrackit.fullstackjavacourse8andhomeworkc8.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerDao dao;

    public List<Customer> getAll(CustomerFilters filters) {
        return dao.getAll(filters);
    }
}
