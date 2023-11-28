package uz.online.springbootpractica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.online.springbootpractica.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @GetMapping("/All")
    public ResponseEntity getAll() {
        Student student1 = new Student(1L, "Mirzo", "vohidov", "3-kurs");
        Student student2 = new Student(2L, "umar", "soliev", "3-kurs");
        Student student3 = new Student(3L, "vohid", "salomov", "3-kurs");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return ResponseEntity.ok(students);
    }


    @GetMapping("/get")
    public ResponseEntity getById(@RequestParam Long id,
                                  @RequestParam String name,
                                  @RequestParam String lastName,
                                  @RequestParam String course) {
        Student student2 = new Student(id, name, lastName, course);
        return ResponseEntity.ok(student2);

    }

    @PostMapping("/save")
    public ResponseEntity create(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody @PathVariable Long id, Student student) {
        Student student1 = new Student(2L, "umar", "soliev", "3-kurs");
        student1.setName(student1.getName());
        student1.setId(student1.getId());
        student1.setLastname(student1.getLastname());
        student1.setCourse(student1.getCourse());
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok("malumot ochirildi");
    }
}
