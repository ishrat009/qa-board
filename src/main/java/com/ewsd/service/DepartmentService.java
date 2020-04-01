package com.ewsd.service;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void add(Department dept) {
		departmentRepository.save(dept);
	}
	
	public List<Department> getAll(){
		return departmentRepository.findAll();
	}
	
	public Department findByDeptName(String deptName) {
		return departmentRepository.findByDeptName(deptName);
	}
	 public Optional<Department> findById(Long id) { 
		  return departmentRepository.findById(id); 
	 }
	public Department findBy_Id(Long Id) {
		return departmentRepository.getOne(Id);
	}

	public String edit(Department dept) {
		// TODO Auto-generated method stub
		Department department = findByDeptName(dept.getDeptName());
		if(department == null) {
			department = findBy_Id(dept.getId());
			if(department == null) {
				departmentRepository.save(dept);
				return "saved";
			}else {
				department.setDeptName(dept.getDeptName());
				departmentRepository.save(department);
				return "updated";
			}
		}else{
			return "updated";
		}
	}
	
	public Department getById(long deptId) {
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Department> sc = cb.createQuery(Department.class);
		Root<Department> root = sc.from(Department.class);
		sc.select(root);
		sc.where(
				cb.and(
						cb.equal(root.get("id"), deptId),
						cb.isTrue(root.get("isDelete"))
				)
		);
		var query = session.getEntityManagerFactory().createEntityManager().createQuery(sc);
		var dept_list = query.getResultList();
		return Optional.ofNullable(dept_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("Dept Not Found With This Id"));
	}
}
