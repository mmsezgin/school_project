package com.cydeo.service.Impl;

import com.cydeo.database.Database;
import com.cydeo.entity.School;

import java.util.List;
import java.util.UUID;

public abstract class CrudServiceImpl <T> {

    public School findById(UUID id){
      return Database.schoolList.stream().filter(p->p.id.toString().equals(id.toString()))
              .findFirst().get();
    }

}
