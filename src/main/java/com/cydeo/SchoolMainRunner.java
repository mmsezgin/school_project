package com.cydeo;

import com.cydeo.entity.Course;
import com.cydeo.entity.Parent;
import com.cydeo.entity.School;
import com.cydeo.entity.Student;
import com.cydeo.service.CRUDService;
import com.cydeo.service.SchoolService;

public class SchoolMainRunner {

   public static CRUDService<School> schoolService;
    public static CRUDService<Course> courseService;
    public static CRUDService<Parent> parentService;
    public static CRUDService<Student> studentService;

    static {
        SchoolMainRunner.schoolService = new SchoolService();
      // SchoolMainRunner.courseService = new CourseService();
      // SchoolMainRunner.parentService = new ParentService();
      // SchoolMainRunner.studentService = new StudentService();
    }

    public static void main(String[] args) {


    }
    public  SchoolMainRunner(){}
/*

    }
 */
}
