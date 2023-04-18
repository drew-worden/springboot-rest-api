package learning.springbootrestapi.controller;

import learning.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//STUDENT CONTROLLER
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

    //GET ENDPOINT FOR QUERY PARAMETER
    @GetMapping("student/query")
    public Student studentQueryParameter(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    //POST ENDPOINT FOR CREATING A NEW STUDENT
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //PUT ENDPOINT FOR UPDATING A STUDENT
    @PutMapping("student/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //DELETE ENDPOINT FOR DELETING A STUDENT
    @DeleteMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        System.out.println(id);
        return "Student deleted successfully.";
    }

    //USING RESPONSE ENTITY CLASS TO CONFIGURE RESPONSE
    @GetMapping("/student-with-entity")
    public ResponseEntity<Student> getStudentUsingEntity() {
        Student student = new Student(1, "Drew", "Worden");
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return new ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "Drew").body(student);
    }
}
