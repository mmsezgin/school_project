package com.cydeo;

import com.cydeo.entity.Student;
import com.cydeo.service.CRUDService;
import com.cydeo.service.StudentService;

import java.util.Scanner;


public class SchoolMainRunner {

//    public static CRUDService<School> schoolService;
//    public static CRUDService<Course> courseService;
//    public static CRUDService<Parent> parentService;
    public static CRUDService<Student> studentService;
//
    static {
//        SchoolMainRunner.schoolService = new SchoolService();
//        SchoolMainRunner.courseService = new CourseService();
//       SchoolMainRunner.parentService = new ParentService();
    SchoolMainRunner.studentService = new StudentService();
    }

    public static void main (String[]args) {

        //User should be able to add, update and delete student
        System.out.println("Welcome to Cydeo School");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to do? Just type id for selection");
            for (int i = 0; i < MenuOption().length; i++) {
                System.out.println(i + "-" + MenuOption()[i]);
            }
            int menuSelection = scanner.nextInt();

            switch (menuSelection) {

                case 0: // save
                    System.out.println("Enter the student name:");
                    String name = scanner.next();
                    Student newStudent =  new Student();
                    studentService.save(newStudent);
                    newStudent.setFirstName(name);
                    System.out.println("Enter the second name");
                    String lastname = scanner.next();
                    newStudent.setLastName(lastname);
                    System.out.println("Enter the student number");
                    Long studentNumber = scanner.nextLong();
                    newStudent.setStudentNumber(studentNumber);
                    break;

                case 1: //findAll
                    System.out.println(studentService.findAll());
                    break;


                case 2: // delete
                    System.out.println("Please enter the  student  number that you want to delete");
                    int studentId = scanner.nextInt();
                    studentService.deleteById(studentId);
                    break;


                case 3: // update
                    System.out.println("Please enter the student number that you want to update");
                    int studentUpdate  = scanner.nextInt();
                    Student updatedStudent = studentService.findById(studentUpdate);
                    System.out.println("What do you want to update?");
                    System.out.println("1.First Name");
                    System.out.println("2.Last Name");
                    System.out.println("3.Student Number");
                    int selectId = scanner.nextInt();

                    switch (selectId){
                        case 1:
                            System.out.println("Please type the first name");
                            String firstName = scanner.next();
                            updatedStudent.setFirstName(firstName);
                            break;
                        case 2:
                            System.out.println("Please type second name");
                            String secondName = scanner.next();
                            updatedStudent.setLastName(secondName);
                            break;
                        case 3:
                            System.out.println("Please type student number");
                            String num = scanner.next();
                            updatedStudent.setLastName(num);
                            break;

                    }

            }

        }
    }
    public static String[] MenuOption(){
        return new String[]{"Save "," FindAll ", " Delete ", "Update"};
    }




}
