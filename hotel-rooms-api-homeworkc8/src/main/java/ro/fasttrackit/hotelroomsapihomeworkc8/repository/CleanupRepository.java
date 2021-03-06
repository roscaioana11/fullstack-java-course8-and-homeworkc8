package ro.fasttrackit.hotelroomsapihomeworkc8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.hotelroomsapihomeworkc8.model.entity.Cleanup;

import java.util.List;

@Repository
public interface CleanupRepository extends JpaRepository<Cleanup, Long> {
    @Query("select c from Cleanup c where c.room.id=:roomId")
    List<Cleanup> findByRoomIdJPQL(long roomId);
}
