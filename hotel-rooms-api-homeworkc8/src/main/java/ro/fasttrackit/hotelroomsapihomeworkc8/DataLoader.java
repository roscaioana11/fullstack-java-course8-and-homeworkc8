package ro.fasttrackit.hotelroomsapihomeworkc8;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.hotelroomsapihomeworkc8.model.entity.*;
import ro.fasttrackit.hotelroomsapihomeworkc8.repository.CleanupRepository;
import ro.fasttrackit.hotelroomsapihomeworkc8.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoomRepository roomRepository;
    private final CleanupRepository cleanupRepository;

    @Override
    public void run(String... args) {
        List<Room> rooms = roomRepository.saveAll(List.of(
                Room.builder()
                    .number("1A")
                    .floor(1)
                    .hotelName("CatsHotel")
                    .roomFacilities(RoomFacilities.builder()
                                .tv(false)
                                .doubleBed(true)
                                .build())
                    .reviews(List.of(
                            Review.builder()
                                .message("good")
                                .rating(5)
                                .tourist("Ioana")
                                .build(),
                            Review.builder()
                                    .message("very good")
                                    .rating(5)
                                    .tourist("Adriana")
                                    .build()
                    ))
                    .build()
        ));

        cleanupRepository.saveAll(List.of(
                Cleanup.builder()
                    .date(LocalDate.now())
                    .cleaningProcedure(List.of(
                            CleaningProcedure.builder()
                                .name("Full cleaning")
                                .outcome(5)
                                .build()
                    ))
                        .room(rooms.get(0))
                    .build(),
                Cleanup.builder()
                    .date(LocalDate.now())
                    .cleaningProcedure(List.of(
                            CleaningProcedure.builder()
                                    .name("Bathroom cleaning")
                                    .outcome(1)
                                    .build()
                    ))
                        .room(rooms.get(0))
                    .build()
        ));
    }
}
