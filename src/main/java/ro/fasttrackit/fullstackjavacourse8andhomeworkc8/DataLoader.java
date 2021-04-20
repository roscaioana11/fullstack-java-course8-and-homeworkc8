package ro.fasttrackit.curs8;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs8.model.entity.*;
import ro.fasttrackit.curs8.repository.CustomerRepository;
import ro.fasttrackit.curs8.repository.ReviewRepository;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public void run(String... args) {
        List<Customer> customers = customerRepository.saveAll(List.of(
                Customer.builder()
                        .name("Ana")
                        .age(26)
                        .address(Address.builder()
                                .street("Unirii")
                                .city("Oradea")
                                .build())
                        .itermOrders(List.of(
                                ItemOrder.builder()
                                        .description("order 1")
                                        .items(List.of(
                                                Item.builder()
                                                        .name("laptop")
                                                        .build(),
                                                Item.builder()
                                                        .name("phone")
                                                        .build()
                                        ))
                                        .build(),
                                ItemOrder.builder()
                                        .description("order 2")
                                        .items(List.of(
                                                Item.builder()
                                                        .name("cicolata")
                                                        .build()
                                        ))
                                        .build()
                        ))
                        .build(),
                Customer.builder()
                        .name("George")
                        .age(22)
                        .address(Address.builder()
                                .street("Republicii")
                                .city("Cluj")
                                .build())
                        .build(),
                Customer.builder()
                        .name("Marius")
                        .age(12)
                        .address(Address.builder()
                                .street("Republicii")
                                .city("Cluj")
                                .build())
                        .build(),
                Customer.builder()
                        .name("Ana")
                        .age(12)
                        .address(Address.builder()
                                .street("Republicii")
                                .city("Cluj")
                                .build())
                        .build()
        ));

        reviewRepository.saveAll(List.of(
                Review.builder()
                        .customer(customers.get(0))
                        .rating(5)
                        .message("Very good")
                        .build(),
                Review.builder()
                        .customer(customers.get(0))
                        .rating(4)
                        .message("Not so good")
                        .build(),
                Review.builder()
                        .customer(customers.get(1))
                        .rating(3)
                        .message("Meh")
                        .build()
        ));

        System.out.println("---------QUERY");
        System.out.println("----- Spring Data Methods");
        printResult(() -> customerRepository.findByAgeGreaterThan(18));
        System.out.println("-----JPQL");
        printResult(() -> customerRepository.findMajorPersonsJPQL(18));
        System.out.println("-----SQL");
        printResult(() -> customerRepository.findPersonsSQL(18));
    }

    private void printResult(Supplier<List<Customer>> queryRunner) {
        System.out.println(queryRunner.get().stream()
                .map(Customer::getName)
                .collect(Collectors.joining(",")));
    }
}
