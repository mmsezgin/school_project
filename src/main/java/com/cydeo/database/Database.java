package com.cydeo.database;

import com.cydeo.entity.Course;
import com.cydeo.entity.Parent;
import com.cydeo.entity.School;
import com.cydeo.entity.Student;
import com.cydeo.enums.WeekDays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Database {

    public static List<Course> courseList = new ArrayList<>(List.of(
            new Course(UUID.randomUUID(),"English", 40, List.of(WeekDays.MONDAY, WeekDays.THURSDAY)),
            new Course(UUID.randomUUID(),"Math",50, List.of(WeekDays.values())),
            new Course(UUID.randomUUID(),"Java",80, List.of(WeekDays.WEDNESDAY))
    ));

    public static List<Parent> parentList = new ArrayList<>(List.of(
            new Parent(UUID.randomUUID(),"John", "Wayne"),
            new Parent(UUID.randomUUID(),"Mike", "Junior")
    ));

    public static List<Student> studentList = new ArrayList<>(List.of(
            new Student(UUID.randomUUID(),12345L, "Jayne", "Smith", parentList.get(0), courseList ),
            new Student(UUID.randomUUID(), 12346L, "Candy", "Brown", parentList.get(1),courseList )
    ));

    public static List<School> schoolList = Arrays.asList(
            new School(UUID.randomUUID(),"ABC_School", studentList,courseList),
            new School(UUID.randomUUID(),"Java_School", studentList,courseList)
    );




}
