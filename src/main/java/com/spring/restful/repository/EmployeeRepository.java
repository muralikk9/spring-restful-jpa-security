package com.spring.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restful.model.Employee;
/**
 * 
 * @author Murali Kodavati
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
