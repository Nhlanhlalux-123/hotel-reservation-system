package com.hotel.repository;

import com.hotel.model.Reservation;
import com.hotel.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Get all reservations for a specific guest
    List<Reservation> findByUserId(Long userId);

    // Get all reservations for a specific room
    List<Reservation> findByRoomId(Long roomId);

    // Get all reservations by status
    List<Reservation> findByStatus(ReservationStatus status);

    // Get all reservations arriving within a date range
    List<Reservation> findByCheckInDateBetween(LocalDate start, LocalDate end);

    // Get a guest's reservations filtered by status
    List<Reservation> findByUserIdAndStatus(Long userId, ReservationStatus status);

    // Check if a room is already booked for the requested dates
    @Query("""
        SELECT COUNT(r) > 0 FROM Reservation r
        WHERE r.room.id = :roomId
        AND r.status NOT IN ('CANCELLED')
        AND r.checkInDate < :checkOut
        AND r.checkOutDate > :checkIn
    """)
    boolean hasConflict(
            @Param("roomId") Long roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut
    );
}