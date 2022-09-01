package com.cydeo;

import com.cydeo.entity.School;
import com.cydeo.service.CRUDService;
import com.cydeo.service.SchoolService;
import com.cydeo.service.impl.SchoolServiceImpl;

import java.util.List;

public class SchoolMainRunner {

    public static CRUDService<School> schoolService;
//    public static CRUDService<Course> courseService;
//    public static CRUDService<Parent> parentService;
//    public static CRUDService<Student> studentService;
//
    static{
      SchoolMainRunner.schoolService = new SchoolServiceImpl();
//        SchoolMainRunner.courseService = new CourseService();
//        SchoolMainRunner.parentService = new ParentService();
//        SchoolMainRunner.studentService = new StudentService();
   }

    public static List<School> getAllSchools(){
        return schoolService.findAll();
    }

    public static void main(String[] args) {




    }


}
