package com.ewsd.repositories;

import com.ewsd.model.Category;
import com.ewsd.model.TermsAndConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Repository
@Transactional
public interface TermsAndConditionsRepository extends JpaRepository<TermsAndConditions, Long>{
    void deleteById(Long id);
    Optional<TermsAndConditions> getById (Long id);
    TermsAndConditions findByName(String name);


}