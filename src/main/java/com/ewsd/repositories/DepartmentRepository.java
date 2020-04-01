package com.ewsd.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewsd.model.Department;


@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDeptName(String deptName);
	 Optional<Department> findById(Long id);
	 

}
