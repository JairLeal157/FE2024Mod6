package com.codefactory.seat.repository;

import com.codefactory.seat.model.SeatStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SeatStatusRepository extends CrudRepository<SeatStatus,Long> {

    @Query("select s.id from SeatStatus s where s.status = :status")
    Long getIdByStatus(@Param("status") SeatStatus.Status status);
}
