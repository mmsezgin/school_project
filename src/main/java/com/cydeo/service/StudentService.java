package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.Student;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Collections;
import java.util.List;

public class StudentService implements CRUDService<Student> {

    private List<Student> db;

    public StudentService() {
        db = Database.studentList;
    }

    @Override
    public Student findById(int id) {
        return db.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(db);  // avoid giving write access to the db
    }

    @Override
    public void save(Student student) {
        if (findById(student.getId()) != null) {
            System.err.printf("Error: A student with id %d already exists:%n%s%n",
                    student.getId(),
                    findById(student.getId()));

            /* the following two print statements are equivalent
            String name = "Igor";
            System.out.print("Hello " + name + "\n");
            System.out.printf("Hello %s%n", name);
            */

            throw new KeyAlreadyExistsException();
        }
        db.add(student);
    }

    @Override
    public void update(Student student) {
        Student exists = findById(student.getId());
        if (exists == null) {
            throw new RuntimeException();
        }
        db.remove(exists);
        save(student);
    }


    @Override
    public void deleteById(long id) {
        db.removeIf(p -> p.getId() == id);
    }
}
