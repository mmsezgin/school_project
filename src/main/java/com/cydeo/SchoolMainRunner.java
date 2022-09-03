package com.cydeo;

import com.cydeo.database.Database;
import com.cydeo.entity.Course;
import com.cydeo.entity.Parent;
import com.cydeo.entity.School;
import com.cydeo.entity.Student;
import com.cydeo.service.CRUDService;
import com.cydeo.service.SchoolService;

import java.util.Scanner;
import java.util.UUID;

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
                System.out.println(i + " " + menuOptions()[i]);
            }
            int menuSelection = input.nextInt();

            switch (menuSelection) {
                case 0:         //add
                    System.out.println("please enter the new school name:");

                    String name = input.next();

                    System.out.println("please enter the new ID");
                    int l = input.nextInt();
                    School schoolToAdd = new School(l, name);
                    schoolService.save(schoolToAdd);

                    break;
                case 1:       //delete
                    System.out.println("Please enter the ID");
                    schoolService.findAll().forEach(p -> System.out.println(p.id + " " + p.getName()));
                    int id = input.nextInt();
                    schoolService.deleteById(id);

                    break;
                case 2:  //update****
                    System.out.println("Please enter the ID");
                    schoolService.findAll().forEach(p -> System.out.println(p.id + " " + p.getName()));
                    int schoolToUpdate = input.nextInt();
                    System.out.println("What would you like to update: 1) name, 2) ID ");
                    int toUpdate1or2 = input.nextInt();

                    switch (toUpdate1or2) {
                        case 1:
                            System.out.println("Enter the School name:");
                            String schoolnewName = input.next();
                            School schoolNewName = Database.schoolList.stream()
                                    .filter(school -> school.getId() == schoolToUpdate)
                                    .findFirst().get();
                            schoolNewName.setName(schoolnewName);

                            schoolService.update(schoolNewName);
                            break;
                        case 2:
                            System.out.println("enter the ID");
                            int schoolNewId = input.nextInt();
                            School schoolToScangeId = Database.schoolList.stream()
                                    .filter(school -> school.getId() == schoolToUpdate)
                                    .findFirst().get();

                            schoolToScangeId.setId(schoolNewId);

                            schoolService.update(schoolToScangeId);
                            break;
                    }
                        break;
                        case 3:
                            System.out.println(schoolService.findAll());
                            break;   //exit
                        case 4:
                            System.exit(0);
                            break;

                    }
            }

        }


    public static String[] menuOptions () {
        return new String[]{"Add", "Delete", "Update", "View schools",
                "Exit"};
    }
}


