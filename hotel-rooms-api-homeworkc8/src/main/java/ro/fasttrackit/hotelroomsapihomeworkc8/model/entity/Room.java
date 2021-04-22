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
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private String number;
    private int floor;
    private String hotelName;

    @OneToMany(cascade = PERSIST)
    List<Review> reviews;

    @OneToMany(cascade = PERSIST)
    List<Cleanup> cleanups;

    @OneToOne(cascade = PERSIST)
    private RoomFacilities roomFacilities;
}
