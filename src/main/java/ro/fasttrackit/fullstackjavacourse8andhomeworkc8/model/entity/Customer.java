package ro.fasttrackit.curs8.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    @OneToOne(cascade = PERSIST)
    private Address address;

    @OneToMany(cascade = PERSIST)
    private List<ItemOrder> itermOrders;
}
