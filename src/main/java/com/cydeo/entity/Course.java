package com.cydeo.entity;

import com.cydeo.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity{

    private String name;
    private int minScore;
    private List<WeekDays> courseDay;

    public Course(UUID id, String name, int minScore, List<WeekDays> courseDay) {
        super(id);
        this.name = name;
        this.minScore = minScore;
        this.courseDay = courseDay;
    }
}
