package com.ewsd.repositories;

import com.ewsd.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch,Long> {
    Batch findByBatchName(String batchName);
}
