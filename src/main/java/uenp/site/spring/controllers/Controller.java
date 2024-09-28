package uenp.site.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uenp.site.spring.domain.Student;
import uenp.site.spring.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String myEndPoint(){
        return "Hello, world!";
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentbyId(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/student/param")
    public String getParam(@RequestParam(defaultValue = "Desconhecido") String name) {
        return "O nome recebido é: " + name;
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}
