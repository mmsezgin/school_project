package com.cydeo.service.impl;

import com.cydeo.database.Database;
import com.cydeo.entity.School;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class CrudServiceImpl <T>{

    public School findById(UUID id) {

     return   Database.schoolList.stream()
                .filter(p->p.id.toString().equals(id.toString()))
                .findFirst().get();

    }

    public List<School> findAll() {
        return Database.schoolList.stream()
                .collect(Collectors.toList());
    }
}
