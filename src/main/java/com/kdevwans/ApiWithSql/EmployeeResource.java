package com.kdevwans.ApiWithSql;

import com.kdevwans.ApiWithSql.model.Employee;
import com.kdevwans.ApiWithSql.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE','EMPLOYEE')")
    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmployee(){
        List<Employee> emp = employeeService.findAllEmployee();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>getEmployeeId(@PathVariable("id") Long id){
        Employee emp = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    @GetMapping("/find/title/{jobTitle}")
    public ResponseEntity<List<Employee>>getEmployeeByJobTitle(@PathVariable("jobTitle") String jobTitle){
        List<Employee> emp = employeeService.findByJobTitle(jobTitle);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('employee:write')")
    @PostMapping("/add")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('employee:write')")
    @PutMapping("/update")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('employee:write')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteEmployeeId(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
