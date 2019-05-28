package com.event.backoffice.model.dao;

import com.event.backoffice.model.Ratings;
import com.event.backoffice.model.Remarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingsDao extends JpaRepository<Ratings, Long> {

    @Query("SELECT r FROM Ratings r WHERE r.ratingId=:polyclinics_id")
    List<Ratings> findAllByPolyclinics(@Param("polyclinics_id") Long polyclinicsId);
}
