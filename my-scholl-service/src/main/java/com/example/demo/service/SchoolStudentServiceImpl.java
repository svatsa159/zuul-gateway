package com.example.demo.service;

import com.example.demo.model.School;
import com.example.demo.repo.SchoolDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class SchoolStudentServiceImpl  implements SchoolStudentService{
    private SchoolDao schoolDao;

    public SchoolStudentServiceImpl(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    @Transactional
    public Iterable<School> getDetails() {
        return schoolDao.findAll();
    }

    @Override
    @Transactional
    public School createSchool(School school) {
        return schoolDao.save(school);
    }

    @Override
    @Transactional
    public Optional<School> findBySchoolId(Integer schoolId) {
        return schoolDao.findById(schoolId);
    }
}
