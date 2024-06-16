package com.project.restapi.demo;

import com.project.restapi.demo.Student;
import com.project.restapi.demo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;
    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        List<Student> students =repo.findAll();
        return students;
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id)
    {
        Student stu=repo.findById(id).get();
        return stu;
    }
    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student)
    {
        repo.save(student);
    }
    @PutMapping("/students/update/{id}")
    public Student updateStudents(@PathVariable int id)
    {
        Student stu = repo.findById(id).get();
        stu.setName("roshan");
        stu.setPercentage(100.0f);
        repo.save(stu);
        return stu;
    }
    @DeleteMapping("students/delete/{id}")
    public Student deleteStudents(@PathVariable int id)
    {
        Student stud=repo.findById(id).get();
        repo.delete(stud);
        return stud;
    }

}
