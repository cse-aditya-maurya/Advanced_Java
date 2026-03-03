package com.company.hrms.repository;

import com.company.hrms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface EmployeeRepository 
        extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    List<Employee> findByDepartment_Name(String name);

    List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);
}