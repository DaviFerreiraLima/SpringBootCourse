package com.compassuol.cruddemo.dao;

import com.compassuol.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define filed for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection


    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implements save method


    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by firstName ",Student.class);
        return  query.getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public List<Student> findByFirstName(String theFirstName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where firstName =:theData",Student.class);
        query.setParameter("theData",theFirstName);
        return  query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
