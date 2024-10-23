package com.example.project3.Repository;
import com.example.project3.Entity.Student; // Make sure to import the correct class
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmailAndPassword(String email,String password);
    Student findByEmail(String email);
    Student findByToken(String token);
}
