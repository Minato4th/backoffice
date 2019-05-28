package com.event.backoffice.model.dao;

import com.event.backoffice.model.Diseases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseasesDao extends JpaRepository<Diseases, Long> {
}
