package ro.fasttrackit.curs8.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemOrder {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToMany(cascade = PERSIST)
    List<Item> items;
}
