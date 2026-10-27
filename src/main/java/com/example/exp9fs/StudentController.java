package com.example.exp9fs;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {
 private final List<Student> students = List.of(new Student(1,"Yaswanth","AIML"),new Student(2,"Rakesh","CSE"),new Student(3,"Priya","AIML"));
 @GetMapping public List<Student> all(){return students;}
 @GetMapping("/{id}") public Student byId(@PathVariable int id){return students.stream().filter(s->s.id()==id).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));}
 @GetMapping("/health") public String health(){return "Student API is running";}
}
