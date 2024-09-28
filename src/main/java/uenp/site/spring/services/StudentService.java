package uenp.site.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uenp.site.spring.domain.Student;
import uenp.site.spring.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student){
        Student studentToUpdate = studentRepository.findById(id).get();
        studentToUpdate.setName(student.getName());
        studentToUpdate.setAge(student.getAge());
        studentToUpdate.setCourse(student.getCourse());
        return studentRepository.save(studentToUpdate);
    }
}
