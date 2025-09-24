package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Long id, Employee updated) {
        Employee existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setAge(updated.getAge());
            existing.setSalary(updated.getSalary());
            existing.setGender(updated.getGender());
            existing.setAddress(updated.getAddress());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
