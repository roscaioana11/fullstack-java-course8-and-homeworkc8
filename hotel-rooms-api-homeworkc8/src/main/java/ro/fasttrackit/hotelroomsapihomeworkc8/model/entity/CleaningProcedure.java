package ro.fasttrackit.hotelroomsapihomeworkc8.model.entity;

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
public class CleaningProcedure {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int outcome;

    @ManyToMany(cascade = PERSIST)
    List<Cleanup> cleanups;
}
