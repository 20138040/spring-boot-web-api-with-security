package com.kdevwans.ApiWithSql.repo;

import com.kdevwans.ApiWithSql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployee extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);
    Employee findEmployeeById(Long id);

    List<Employee> getByJobTitle(String title);
}
