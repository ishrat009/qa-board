package com.ewsd.service;

import com.ewsd.model.Batch;
import com.ewsd.repositories.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService {
    @Autowired
    private BatchRepository batchRepository;
    public boolean add(Batch batch) {
        if(!exists(batch.getBatchName())) {
            batchRepository.save(batch);
            return true;
        }else {
            return false;
        }
    }

    public Batch findByName(String name) {
        return batchRepository.findByBatchName(name);
    }

    public boolean exists(String name) {
        if(findByName(name)!=null) {
            return true;
        }else {
            return false;
        }
    }

    public List<Batch> getAll() {
        // TODO Auto-generated method stub
        return batchRepository.findAll();
    }

    public Batch findById(Long id) {
        // TODO Auto-generated method stub
        return batchRepository.getOne(id);
    }

    public boolean delete(Batch cat) {
        // TODO Auto-generated method stub
        batchRepository.delete(cat);
        return true;
    }
}
