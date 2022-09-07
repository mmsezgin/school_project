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

        System.out.println("Please select from the following options: ");

        for (int i = 0; i < menuOptionsForStart().length; i++) {
            System.out.println(i+" -"+menuOptionsForStart()[i]);
        }

        int secltionForStartMenu=input.nextInt();
        switch(secltionForStartMenu){

            case 0: // School

                boolean enterLoop=true;
                while(enterLoop) {
                    System.out.println(" Type id for selection");

                    for (int i = 0; i < prepareMenuOptions().length; i++) {
                        System.out.println(i + "-" + prepareMenuOptions()[i]);
                    }
                    int menuSelection = input.nextInt();

                    switch (menuSelection) {
                        case 0: //Add/Save
                            System.out.println("Please enter the new School name:");
                            String name = input.next();
                            System.out.println("Please enter the school ID:");
                            int schoolId = input.nextInt();

                            schoolService.save(new School(schoolId, name));

                            break;

                        case 1:// Delete
                            System.out.println("Please enter the ID of the School you would like to delete:");
                            schoolService.findAll().forEach(p -> System.out.println(p.id + " " + p.getName()));

                            int id = input.nextInt();

                            schoolService.deleteById(id);

                            break;

                        case 2: //Update

                            System.out.println("Select the ID of  the school you would like to update?");
                            schoolService.findAll().forEach(p -> System.out.println(p.id + " " + p.getName()));
                            int schoolToUpdate = input.nextInt();
                            System.out.println("What would you like to update 1: School Name, 2: School ID");
                            int sectionToUpdate = input.nextInt();

                            switch (sectionToUpdate) {
                                case 1:
                                    System.out.println("Please enter the NEW school name:");
                                    String schoolNewName = input.next();
                                    School schoolToUdpateName = Database.schoolList.stream()
                                            .filter(school -> school.getId() == schoolToUpdate)
                                            .findFirst().get();

                                    schoolToUdpateName.setName(schoolNewName);

                                  //  schoolService.update(schoolToUdpateName);

                                    break;

                                case 2:

                                    System.out.println("Please enter the NEW school ID:");
                                    int schoolNewId = input.nextInt();
                                    School schoolToChangeId = Database.schoolList.stream()
                                            .filter(school -> school.getId() == schoolToUpdate)
                                            .findFirst().get();

                                    schoolToChangeId.setId(schoolNewId);

                                  //  schoolService.update(schoolToChangeId);
                                    break;
                            }

                            break;

                        case 3: //View schools
                            System.out.println(schoolService.findAll());

                            break;

                        case 4://Exit
                            enterLoop = false;
                            break;
                    }

                }

                break;
            case 1:// Course
                break;
            case 2: //Student
                break;
            case 3: //Parent
                break;
            case 4: //Exit
                System.exit(1);
                break;




        }

    }



    public static String [] prepareMenuOptions (){
        return new String [] {"Add", "Delete", "Update","View schools", "Exit"};
    }

public static String [] menuOptionsForStart(){
        return new String [] {"School", "Course", "Student", "Parent", "Exit"};
}



}
