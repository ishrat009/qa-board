package com.ewsd.service;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewsd.model.Category;
import com.ewsd.model.Department;
import com.ewsd.repositories.DepartmentRepository;

import com.ewsd.config.persistence.HibernateConfig;
import com.ewsd.exceptions.ResourceNotFoundException;


@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	private HibernateConfig hibernateConfig;
	
	public DepartmentService(HibernateConfig hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
	}
	
	public boolean add(Department deptEntity) {
		if(!exists(deptEntity.getDeptName())) {
			departmentRepository.save(deptEntity);
			return true;
		}else {
			return false;
		}
	}
	
	private boolean exists(String deptName) {
		if(findByDeptName(deptName)!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Department> getAll(){
		return departmentRepository.findAll();
	}
	
	public Department findByDeptName(String deptName) {
		return departmentRepository.findByDeptName(deptName);
	}
	
	public Department findById(Long Id) {
		return departmentRepository.getOne(Id);
	}
	
	public Department getById(long deptId) {
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		//System.out.println("Department start :"+deptId);
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
		Root<Department> root = criteriaQuery.from(Department.class);
		criteriaQuery.select(root);
		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get("id"), deptId),
						criteriaBuilder.isFalse(root.get("isDelete"))
				)
		);
		var query = session.getEntityManagerFactory().createEntityManager().createQuery(criteriaQuery);
		var dept_list = query.getResultList();
		System.out.println("Department");
		System.out.println(dept_list);
		return Optional.ofNullable(dept_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("No department was found with this ID!"));
	}
	
	public void edit(Department dept) {
		departmentRepository.save(dept);
	}

	public boolean delete(Department dept) {
		departmentRepository.delete(dept);
		return true;
	}
} // End of Class
