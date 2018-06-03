package pl.dmcs.rkotas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.rkotas.model.Student;
import pl.dmcs.rkotas.model.request.AddStudentRequest;
import pl.dmcs.rkotas.repository.StudentRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/students")
public class StudentController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAllStudents()
    {
        return studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Student findStudent(@PathVariable long id)
    {
        return studentRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student addStudent(@RequestBody AddStudentRequest addStudentRequest)
    {
        Student student = new Student();
        student.setStudentName(addStudentRequest.getStudentName());
        student.setStudentCourses(addStudentRequest.getStudentCourses());
        return studentRepository.save(student);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Student putStudent(@RequestBody AddStudentRequest putStudentRequest)
    {
        Student student = new Student();
        student.setId(putStudentRequest.getId());
        student.setStudentName(putStudentRequest.getStudentName());
        student.setStudentCourses(putStudentRequest.getStudentCourses());
        return studentRepository.save(student);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteContact (@PathVariable("id") long id) {

        try
        {
            studentRepository.deleteById(id);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

