package uz.online.springbootpractica.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.online.springbootpractica.domein.Employee;
import uz.online.springbootpractica.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findAllByNameStartingWith(name);
    }


    public List<Employee> findAllByParam(String name) {
        return employeeRepository.findAllByNameLike(name);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);

    }

    @Scheduled(cron = "0 45 15 * * *")
    public Employee saveSchedule(Employee employee) {
        Employee employee1 = new Employee();
        employee1.setName("jons");
        employee1.setLastName("smith");
        return employeeRepository.save(employee);
    }
}
