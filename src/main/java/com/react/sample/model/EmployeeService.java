package com.react.sample.model;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.react.sample.model.EmployeeEntity;
import com.react.sample.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity findOne(int id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new NoSuchElementException("Employee not found");
        }
    }

    public EmployeeEntity save(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeEntity update(EmployeeEntity employee) {
        if (employeeRepository.existsById(employee.getId())) {
            return employeeRepository.save(employee);
        } else {
            throw new NoSuchElementException("Employee not found");
        }
    }

    public void delete(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Employee not found");
        }
    }
    
    public EmployeeEntity uploadEmployeePhoto(int id, MultipartFile photo) throws IOException {
        EmployeeEntity employee = findOne(id);
        employee.setPhoto(photo.getBytes());
        return save(employee);
    }
}







