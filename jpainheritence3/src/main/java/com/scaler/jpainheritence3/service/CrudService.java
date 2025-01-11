package com.scaler.jpainheritence3.service;

import com.scaler.jpainheritence3.models.Instructor;
import com.scaler.jpainheritence3.models.Student;
import com.scaler.jpainheritence3.models.User;
import com.scaler.jpainheritence3.repository.InstructorRepository;
import com.scaler.jpainheritence3.repository.StudentRepository;
import com.scaler.jpainheritence3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void doCrudOperations(){
        User user = new User();
        user.setEmail("rrj@gmail.com");
        user.setName("Rituraj Jain");
        User savedUserByUserRepo = userRepository.save(user);
        Instructor instructor = new Instructor();
        instructor.setInstructor_rating(4.2);
        instructor.setName("Sandeep");
        instructor.setEmail("ss@gmail.com");
        Instructor savedByInsRepo = instructorRepository.save(instructor);
        Student student = new Student();
        student.setName("Rahul");
        student.setEmail("rr@gmail.com");
        student.setPsp(99.9);
        student.setBatchName("22March");
        User savedStuByUserRepo = userRepository.save(student);

        System.out.printf("User by user %s, Instructor by ins %s, Student by user %s",savedUserByUserRepo.getId(),savedByInsRepo.getId()
        ,savedStuByUserRepo.getId());
        System.out.println();
        System.out.println("From user Repo");
        List<User> users = userRepository.findAll();
        System.out.println(users);
        System.out.println("From Student rep");
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
        System.out.println("From Instructor rep");
        List<Instructor> instructors = instructorRepository.findAll();
        System.out.println(instructors);
    }
}
