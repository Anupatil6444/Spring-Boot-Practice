package com.EmployeeSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeSystem.Entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {

}
