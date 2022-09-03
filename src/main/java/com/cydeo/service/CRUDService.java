package com.cydeo.service;

import java.util.List;
import java.util.UUID;

public interface CRUDService<T>{

    T findById(int id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void deleteById(long id);

}
