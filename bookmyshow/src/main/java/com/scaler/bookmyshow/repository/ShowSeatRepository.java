package com.scaler.bookmyshow.repository;

import com.scaler.bookmyshow.models.Seat;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats, Show show);
    Optional<ShowSeat> findBySeatAndShow(Seat seat, Show show);
}
