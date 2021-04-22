package ro.fasttrackit.hotelroomsapihomeworkc8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.hotelroomsapihomeworkc8.model.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
