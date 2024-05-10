package hogwarts.school_files.controller;

import hogwarts.school_files.model.Student;
import hogwarts.school_files.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id){
        Student student = studentService.findStudent(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student){
        Student editedStudent = studentService.editStudent(student);
        if (editedStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getStudentWithAgeBetween(@RequestParam(required = false) Long min,
                                                                        @RequestParam(required = false) Long max){
        if (min != null && max != null){
            return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
        }
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
