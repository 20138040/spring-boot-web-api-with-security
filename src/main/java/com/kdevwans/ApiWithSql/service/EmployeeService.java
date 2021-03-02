package com.kdevwans.ApiWithSql.service;

import com.kdevwans.ApiWithSql.model.Employee;
import com.kdevwans.ApiWithSql.repo.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final IEmployee employee;

    @Autowired
    public EmployeeService(IEmployee employee) {
        this.employee = employee;
    }

    public Employee addEmployee(Employee emp){
        emp.setEmployeeCode(UUID.randomUUID().toString());
        return employee.save(emp);
    }

    public List<Employee> findAllEmployee(){
        return employee.findAll();
    }

    public  Employee updateEmployee(Employee emp){
        return employee.save(emp);
    }

    public  void deleteEmployee(Long id){
        employee.deleteById(id);
        // employee.deleteEmployeeById(id);
    }

    public  Employee findEmployeeById(Long id){
        return employee.findEmployeeById(id);
    }

    public List<Employee> findByJobTitle(String title){
        return employee.getByJobTitle(title);
    }

}

