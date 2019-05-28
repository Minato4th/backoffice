package com.event.backoffice.model.dao;

import com.event.backoffice.model.Polyclinics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PolyclinicsDao extends JpaRepository<Polyclinics, Long> {

    @Query("SELECT p FROM Polyclinics p WHERE p.clinicId=:polyclinics_id")
    Polyclinics findPolyclinicsById(@Param("polyclinics_id") Long polyclinicsId);

    @Query("SELECT p FROM Polyclinics p WHERE p.region=:region")
    List<Polyclinics> findPolyclinicsByRegion(@Param("region") String region);
}
