package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.Student;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentService implements CRUDService<Student> {

    private List<Student> db;

    public StudentService() {
        db = Database.studentList;
    }

    @Override
    public Student findById(int id) {
        // iterate through each student
        // check id
        // if id == id then return student
        return db.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);

//        for (Student student : db){
//          if (student.getId() == id){
//              return student;
//          }
//        }
//      return null;
    }

    @Override
    public List<Student> findAll() {
        return db;
    }

    @Override
    public void save(Student student) {
        if (findById(student.getId()) != null) {
            throw new KeyAlreadyExistsException();
        }
        db.add(student);
    }

    @Override
    public void update(Student student) {
        db.remove(findById(Math.toIntExact(student.getStudentNumber())));
        save(student);
        }


    @Override
    public void deleteById(long id) {
        db.removeIf(p->p.getStudentNumber()==id);


    }

}
