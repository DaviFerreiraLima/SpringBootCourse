package com.compassuol.cruddemo.dao;

import com.compassuol.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByFirstName(String theFirstName);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
