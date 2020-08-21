package com.example.demo.service;

import com.example.demo.model.School;

import java.util.Optional;

public interface SchoolStudentService {

    public Iterable<School> getDetails();
    public School createSchool(School school);
    public Optional<School> findBySchoolId(Integer schoolId);
}
