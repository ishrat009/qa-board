package com.ewsd.repositories;

import com.ewsd.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch,Long> {
    void deleteById(Long id);
    Batch findByBatchName(String batchName);
    Optional<Batch> getById (Long id);
}
