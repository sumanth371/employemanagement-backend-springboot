package com.employee.employeeApi.services;

import com.employee.employeeApi.entity.EmployeeEntity;
import com.employee.employeeApi.model.Employee;
import com.employee.employeeApi.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

     @Autowired
     EmployeeEntity employeeEntity;
    public Employee createEmployee(Employee emp){

        BeanUtils.copyProperties(emp,employeeEntity);
        employeeRepository.save(employeeEntity);
        return  emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity>emlist=employeeRepository.findAll();
        List<Employee>lis=  emlist.stream().map(emp->new Employee(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmailId(),emp.getDob(),emp.getParentName(),emp.getAddress(),emp.getCity(),emp.getPhone())).collect(Collectors.toList());
        return lis;

    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity find=employeeRepository.findById(id).get();
        employeeRepository.delete(find);
        return true;
    }

    public Employee getEmployee(long id){

        EmployeeEntity em=employeeRepository.findById(id).get();
        Employee emp=new Employee();
        BeanUtils.copyProperties(em,emp);
        return emp;
    }

    public Employee updateEmployee(long id,Employee emp){
        EmployeeEntity em=employeeRepository.findById(id).get();

        em.setFirstName(emp.getFirstName());
        em.setEmailId(emp.getEmailId());
        em.setLastName(emp.getLastName());
       employeeRepository.save(em);
        return emp;
    }
}
