package com.hotel.repository;

import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // Get all rooms by status (AVAILABLE, BOOKED, MAINTENANCE)
    List<Room> findByStatus(RoomStatus status);

    // Get all rooms by type (SINGLE, DOUBLE, SUITE)
    List<Room> findByType(RoomType type);

    // Get rooms within a price range
    List<Room> findByPricePerNightBetween(Double min, Double max);

    // Find a specific room by its room number
    Optional<Room> findByRoomNumber(String roomNumber);

    // Find all rooms with no booking conflicts for the given dates
    @Query("""
        SELECT r FROM Room r
        WHERE r.id NOT IN (
            SELECT res.room.id FROM Reservation res
            WHERE res.status NOT IN ('CANCELLED')
            AND res.checkInDate < :checkOut
            AND res.checkOutDate > :checkIn
        )
    """)
    List<Room> findAvailableRooms(
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut
    );
}