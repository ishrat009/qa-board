package com.ewsd.service;

import com.ewsd.config.persistence.HibernateConfig;
import com.ewsd.exceptions.ResourceNotFoundException;
import com.ewsd.model.Batch;
import com.ewsd.model.Category;
import com.ewsd.repositories.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class BatchService {
    @Autowired
    private BatchRepository batchRepository;
    private HibernateConfig hibernateConfig;
    public BatchService(HibernateConfig hibernateConfig) {
        this.hibernateConfig = hibernateConfig;
    }
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

    public boolean delete(Batch batch) {
        // TODO Auto-generated method stub
        batchRepository.delete(batch);
        return true;

    }
    public void getDelete(Long id) {
        // TODO Auto-generated method stub
        batchRepository.deleteById(id);
    }
    //todo:test for edit
    public Optional<Batch> getById(Long id) {
        // TODO Auto-generated method stub
        var terms = batchRepository.getById(id);
        return terms;
    }

    /*public Batch getById(Long batchId) {

        var session = hibernateConfig.getSession();
        var transaction = session.getTransaction();
        if (!transaction.isActive()) {
            transaction = session.beginTransaction();
        }
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Batch> sc = cb.createQuery(Batch.class);
        Root<Batch> root = sc.from(Batch.class);
        sc.select(root);
        sc.where(
                cb.and(
                        cb.equal(root.get("id"), batchId),
                        cb.isTrue(root.get("isDelete"))
                )
        );
        var query = session.getEntityManagerFactory().createEntityManager().createQuery(sc);
       *//* var dept_list = query.getResultList();

        return Optional.ofNullable(dept_list.get(0))
                .orElseThrow(() -> new ResourceNotFoundException("Tag Not Found With This Id"));*//*
       return Optional.ofNullable(batchId.)
    }*/
  /*  public void edit(Batch batch) {
        batchRepository.save(batch);
    }*/
    public Batch edit(Batch batch) {

//        TermsAndConditions termCon = new TermsAndConditions();
//        BeanUtils.copyProperties(terms, termCon);
       // terms.setTextMessage(terms.getTextMessage());
        return  batchRepository.save(batch);
    }
}
