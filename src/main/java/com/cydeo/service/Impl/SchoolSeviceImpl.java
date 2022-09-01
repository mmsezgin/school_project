package com.cydeo.service.Impl;

import com.cydeo.entity.School;
import com.cydeo.service.SchoolService;

import java.util.List;
import java.util.UUID;

public class SchoolSeviceImpl extends CrudServiceImpl implements SchoolService {
    @Override
    public School findById(UUID id)  {
        return super.findById(id);
    }

    @Override
    public List<School> findAll() {
        return null;
    }

    @Override
    public void save(School school) {

    }

    @Override
    public void update(School school) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
