package com.employee.employeeApi.controller;


import com.employee.employeeApi.model.Employee;
import com.employee.employeeApi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v2")
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
               return employeeService.createEmployee(employee);
    }

    @GetMapping("/employess")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable(name="id") long id){
        boolean deleted=false;
        deleted= employeeService.deleteEmployee(id);
        Map<String,Boolean>response=new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name="id")long id){
       Employee em= employeeService.getEmployee(id);
        return ResponseEntity.ok(em);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name="id")long id,@RequestBody Employee employee){
        employee=employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);
    }
}
