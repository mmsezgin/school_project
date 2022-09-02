package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.School;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.cydeo.database.Database.schoolList;

public class SchoolService implements CRUDService<School> {
    @Override
    public School findById(UUID id) {
        return schoolList.stream()
                .filter(school -> school.getId().toString().equals(id.toString()))
                .findAny().get();
    }

    @Override
    public List<School> findAll() {
        return schoolList.stream()
                .collect(Collectors.toList());
    }

    @Override
    public void save(School school) {
        schoolList.add(school);

    }

    @Override
    public void update(School school) {
        for (int i = 0; i < schoolList.size(); i++) {
            if (schoolList.get(i).getId().toString().equals(school.getId().toString())) {
                schoolList.set(i, school);
            }
        }

    }



    @Override
    public void deleteById(School school){
        schoolList.removeIf(p->p.getId().toString().equals(school.getId().toString())) ;

    }
}
