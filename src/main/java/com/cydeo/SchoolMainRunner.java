package com.cydeo;

import com.cydeo.entity.Course;
import com.cydeo.entity.Parent;
import com.cydeo.entity.School;
import com.cydeo.entity.Student;
import com.cydeo.service.CRUDService;
import com.cydeo.service.SchoolService;

import java.util.Scanner;

public class SchoolMainRunner {

   public static CRUDService<School> schoolService;
    public static CRUDService<Course> courseService;
    public static CRUDService<Parent> parentService;
    public static CRUDService<Student> studentService;

    static {
        SchoolMainRunner.schoolService = new SchoolService();
     //  SchoolMainRunner.courseService = new CourseService();
      // SchoolMainRunner.parentService = new ParentService();
       //SchoolMainRunner.studentService = new StudentService();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the school portal");
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Type id for selection");
            for (int i = 0; i < menuOptions().length; i++) {
                System.out.println(i+" "+menuOptions()[i]);
            }
            int menuSelection = input.nextInt();

            switch (menuSelection){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                    
            }
        }

    }
    public static String[] menuOptions(){
        return new String []{"Add","Delete","Update","View schools","Exit"};
    }
    public  SchoolMainRunner(){}
/*

    }
 */
}
