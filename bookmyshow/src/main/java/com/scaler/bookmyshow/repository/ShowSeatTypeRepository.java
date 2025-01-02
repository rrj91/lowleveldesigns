package com.scaler.bookmyshow.repository;

import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
    ShowSeatType findByShowAndSeatType(Show show, SeatType seatType);
}
