package ro.fasttrackit.hotelroomsapihomeworkc8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.hotelroomsapihomeworkc8.model.entity.Cleanup;
import ro.fasttrackit.hotelroomsapihomeworkc8.model.entity.Room;
import ro.fasttrackit.hotelroomsapihomeworkc8.repository.CleanupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CleanupService {
    private final CleanupRepository cleanupRepository;

    public List<Cleanup> getCleanupsForRoom(long roomId){
        return cleanupRepository.findByRoomIdJPQL(roomId);
    }
}
