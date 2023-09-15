package com.employee.employeeApi.services;

import com.employee.employeeApi.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface EmployeeService {
    public Employee createEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public boolean deleteEmployee(long id);

    public Employee getEmployee(long id);

    public  Employee updateEmployee(long id,Employee em);
}
