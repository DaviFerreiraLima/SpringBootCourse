package com.compassuol.cruddemo;

import com.compassuol.cruddemo.dao.StudentDAO;
import com.compassuol.cruddemo.entity.Student;
import org.aspectj.lang.annotation.After;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
          createMultipleStudent(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
       int rowsDeleted = studentDAO.deleteAll();
        System.out.println("Number of rows deleted: "+rowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        System.out.println("Deleting the  student with the id 4 ");

        studentDAO.delete(4);

        System.out.println("Deleted the  student: ");




    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Before the update");
        List<Student> students = studentDAO.findAll();

        for (Student tempStudent: students) {
            System.out.println(tempStudent);
        }

        Student myStudent = studentDAO.findById(1);

        System.out.println("Getting the student with the id "+myStudent.getId());

        System.out.println("Updating student");

        myStudent.setFirstName("Simone");

        studentDAO.update(myStudent);

        System.out.println("Updated student: " + myStudent);

        System.out.println("List of all students");

        System.out.println("After the update");
       students = studentDAO.findAll();

        for (Student tempStudent: students) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudentsByFirstName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByFirstName("Elton");

        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }
    private void findAll(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findAll();

        for (Student tempStudent: students) {
            System.out.println(tempStudent);
        };
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating a Student");
        Student student= new Student("Elton","Lima","jhon@gmail.com");
        //saving the student object
        studentDAO.save(student);


        //display the id of the saved student
        System.out.println("Save student. Generated id: " + student.getId());

        //retrieve student based on the id: primary key
        System.out.println("Retrieving the student with id: "+ student.getId());

        Student myStudent = studentDAO.findById(student.getId());

        System.out.println("Found the Student: "+myStudent);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        //create multiple students

        System.out.println("Creating 3 Students");
        Student student1 = new Student("John","Lima","fks@gmail.com");
        Student student2 = new Student("Mary","Lima","mary@gmail.com");
        Student student3= new Student("Elton","Lima","jhon@gmail.com");

        //save the student objects

        System.out.println("Saving the students");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating a new Student");
        Student student = new Student("Davi","Lima","daviferreilima@gmail.com");

        // save the student object
        System.out.println("Saving the student");
        studentDAO.save(student);

        //display id of the saved student
        System.out.println("The created student is in the id: " + student.getId());
    }

}
