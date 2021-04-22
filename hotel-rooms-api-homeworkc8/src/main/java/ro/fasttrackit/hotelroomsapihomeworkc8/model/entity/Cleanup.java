package ro.fasttrackit.hotelroomsapihomeworkc8.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cleanup {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Room room;

    @ManyToMany(cascade = PERSIST)
    List<CleaningProcedure> cleaningProcedure;
}
