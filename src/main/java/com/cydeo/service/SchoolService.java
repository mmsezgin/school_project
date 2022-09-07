package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.School;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.cydeo.database.Database.schoolList;

public class SchoolService <T> implements CRUDService<School> {


    @Override
    public School findById(int id) {
        return schoolList.stream()
                .filter(school -> school.getId()==id)
                .findAny().get(); //use find first
    }

    @Override
    public List<School> findAll() {

       return schoolList;
    }


    public void save(School school){
        schoolList.add(school);
    }

    @Override
    public void update(School school) {

        for (int i = 0; i < schoolList.size(); i++) {
        if(schoolList.get(i).getId()==(school.getId())){
            schoolList.set(i,school);
            }
        }
    }

    @Override
    public void deleteById(long id) {
        schoolList
                .removeIf(p->p.getId()==(id));
            }// hard delete, should use a soft delete instead



}
