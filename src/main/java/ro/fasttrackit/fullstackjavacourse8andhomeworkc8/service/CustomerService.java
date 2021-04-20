package ro.fasttrackit.curs8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs8.model.CustomerFilters;
import ro.fasttrackit.curs8.model.entity.Customer;
import ro.fasttrackit.curs8.repository.CustomerDao;
import ro.fasttrackit.curs8.repository.CustomerRepository;

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
