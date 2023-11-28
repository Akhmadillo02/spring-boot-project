package uz.online.springbootpractica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.online.springbootpractica.domein.Employee;
import uz.online.springbootpractica.security.SecurityUtils;
import uz.online.springbootpractica.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity create(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @PutMapping("/update")
    public ResponseEntity updaate(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/get/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        Optional<String>optionalS = SecurityUtils.getCurrentUserName();
        List<Employee> employees = employeeService.findByName(name);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employee/search")
    public ResponseEntity getAllSearch(@RequestParam String name) {
        List<Employee> employees = employeeService.findAllByParam(name);
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("employee delete");
    }
}
