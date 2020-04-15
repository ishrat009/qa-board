package com.ewsd.service;

import com.ewsd.config.persistence.HibernateConfig;
import com.ewsd.model.TermsAndConditions;
import com.ewsd.repositories.TermsAndConditionsRepository;
//import com.ewsd.request_models.TermRm;
import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TermsAndConditionsService {
    @Autowired
    private TermsAndConditionsRepository termsAndConditionsRepository;

    private HibernateConfig hibernateConfig;

    public TermsAndConditionsService(HibernateConfig hibernateConfig) {
        this.hibernateConfig = hibernateConfig;
    }




    public void addTerms(TermsAndConditions termsAndCondition) {
        LocalDateTime entry_date = LocalDateTime.now();
        var terms = new TermsAndConditions();
        BeanUtils.copyProperties(termsAndCondition, terms);
        terms.setEntryDate(entry_date);
        terms.setTextMessage(terms.getTextMessage());

        termsAndConditionsRepository.save(terms);
    }

    public List<TermsAndConditions> getAll() {
        // TODO Auto-generated method stub
        return termsAndConditionsRepository.findAll();
    }

    public void getDelete(Long id) {
        // TODO Auto-generated method stub
        termsAndConditionsRepository.deleteById(id);
    }

    public Optional<TermsAndConditions> getById(Long id) {
        // TODO Auto-generated method stub
        var terms = termsAndConditionsRepository.getById(id);
        return terms;
    }

//    public TermsAndConditions updateTerms(TermsAndConditions termsAndCondition) {
//
//
//        LocalDateTime entry_date = LocalDateTime.now();
//        var terms = new TermsAndConditions();
//        BeanUtils.copyProperties(termsAndCondition, terms);
//        terms.setUpdateDate(entry_date);
//        terms.setTextMessage(terms.getTextMessage());
//        terms.setName(terms.getName());
//
//        var updateTerms = termsAndConditionsRepository.save(terms);
//        return updateTerms;
//    }
public void updateTerms(TermsAndConditions term) {
//    var termOptional = termsAndConditionsRepository.getById(term.getId());
//    if (!termOptional.isPresent()) {
//        termsAndConditionsRepository.save(term);
//    }else {
//        var termFromDb = termOptional.get();
//        BeanUtils.copyProperties(term,termFromDb);
        termsAndConditionsRepository.save(term);
//    }
}

    public TermsAndConditions edit(TermsAndConditions terms) {

//        TermsAndConditions termCon = new TermsAndConditions();
//        BeanUtils.copyProperties(terms, termCon);
//        terms.setTextMessage(terms.getTextMessage());
       return  termsAndConditionsRepository.save(terms);
    }

    public void updateTerm(TermsAndConditions term) {


        var session = hibernateConfig.getSession();
        var transection = session.beginTransaction  ();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TermsAndConditions> userCriteriaQuery = cb.createQuery(TermsAndConditions.class);
        Root<TermsAndConditions> root = userCriteriaQuery.from(TermsAndConditions.class);

        userCriteriaQuery.where(cb.equal(root.get("name"),term.getName()));

        var query  = session.createQuery(userCriteriaQuery);
        var termsCon = new TermsAndConditions();
        try {
            termsCon = query.getSingleResult();
        }catch (HibernateException e){

            e.printStackTrace();
        }

        BeanUtils.copyProperties(term,termsCon);
//        user.setUpdateDate(LocalDateTime.now());

        try {
            session.update(termsCon);
            transection.commit();
        }catch(HibernateException e) {

            if(transection!= null ) {
                transection.rollback();
            }
            e.printStackTrace();

        }

    }

    public void saveEditedTeam(TermsAndConditions dto){

        TermsAndConditions team = new TermsAndConditions();
        BeanUtils.copyProperties(dto,team);

        var session = hibernateConfig.getSession();
        var transaction = session.getTransaction();

        if (!transaction.isActive()){
            transaction = session.beginTransaction();
        }

        try{
            session.update(team);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

}
//    public void edit(TermRm term) {
//
//       if(term.getId() != null){
//
//           term.setTextMessage(term.getTextMessage());
//         tremRepo.save(term);
//       }
//    }
//}