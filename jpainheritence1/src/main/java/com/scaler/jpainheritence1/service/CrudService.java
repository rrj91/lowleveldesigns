package com.scaler.jpainheritence1.service;

import com.scaler.jpainheritence1.models.Instructor;
import com.scaler.jpainheritence1.models.Student;
import com.scaler.jpainheritence1.models.User;
import com.scaler.jpainheritence1.repository.InstructorRepository;
import com.scaler.jpainheritence1.repository.StudentRepository;
import com.scaler.jpainheritence1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    }
}
