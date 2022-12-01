package com.cybage.winepark.repository;

import com.cybage.winepark.domain.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Integer> {
    Wine findByWineId(Integer wineId);
}