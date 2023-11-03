package dev.bernasss12.backend.controller;

import dev.bernasss12.backend.exception.ResourceNotFoundException;
import dev.bernasss12.backend.model.Employee;
import dev.bernasss12.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:4200/", "http://localhost:3000/" })
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok(
                employeeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No employee with id: " + id)
                        )
        );
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No employee with id: " + id)
                );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailId(employee.getEmailId());

        return ResponseEntity.ok(
                employeeRepository.save(existingEmployee)
        );
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Long> deleteEmployeeById(@PathVariable long id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

}
