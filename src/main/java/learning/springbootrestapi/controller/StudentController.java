package learning.springbootrestapi.controller;

import learning.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    //GET ENDPOINT FOR RETURNING STATIC SINGLE JSON OBJECT
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Drew",
                "Worden"
        );
        return student;
    }

    //GET ENDPOINT FOR RETURNING STATIC MULTIPLE JSON OBJECT
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Drew", "Worden"));
        students.add(new Student(2, "John", "Smith"));
        students.add(new Student(3, "Jane", "Smith"));
        return students;
    }

    //GET ENDPOINT FOR PATH VARIABLE
    @GetMapping("student/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
