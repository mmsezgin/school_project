package com.cydeo;

import com.cydeo.database.Database;
import com.cydeo.entity.School;
import com.cydeo.entity.Student;
import com.cydeo.service.CRUDService;
import com.cydeo.service.SchoolService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class SchoolMainRunner {

    public static CRUDService<School> schoolService;
//    public static CRUDService<Course> courseService;
//    public static CRUDService<Parent> parentService;
//    public static CRUDService<Student> studentService;
//
    static{
      SchoolMainRunner.schoolService = new SchoolService();
//        SchoolMainRunner.courseService = new CourseService();
//        SchoolMainRunner.parentService = new ParentService();
//        SchoolMainRunner.studentService = new StudentService();
   }



    public static void main(String[] args) {



        //User should be able to ADD, UPDATE, and DELETE a school.

        System.out.println("Welcome to the school portal");
        Scanner input=new Scanner(System.in);

        while(true){
            System.out.println(" Type id for selection");

            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i+"-"+prepareMenuOptions()[i]);
            }
            int menuSelection= input.nextInt();

            switch(menuSelection){
                case 0: //Add/Save
                    System.out.println("Please enter the new School name:");
                    String name= input.next();
                    System.out.println("Please enter the school ID:");
                    int schoolId= input.nextInt();

                    School schoolToAdd= new School(schoolId, name);
                    schoolService.save(schoolToAdd);

                    break;

                case 1:// Delete
                    System.out.println("Please enter the ID of the School you would like to delete:");
                    schoolService.findAll().forEach(p-> System.out.println(p.id+" "+p.getName()));

                    int id= input.nextInt();

                    schoolService.deleteById(id);

                    break;

                case 2: //Update

                    System.out.println("What school would you like to update?");
                    break;

                case 3: //View schools
                    System.out.println(schoolService.findAll());
                    break;

                case 4://Exit
                    System.exit(1);
                    break;
            }
        }

    }



    public static String [] prepareMenuOptions (){
        return new String [] {"Add", "Delete", "Update","View schools", "Exit"};
    }





}
