package com.event.backoffice.model.dao;

import com.event.backoffice.model.Medicaments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentsDao extends JpaRepository<Medicaments, Long> {
}
