package com.selcuk.springcomplex1.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.selcuk.springcomplex1.data.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

}
