package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface DataAccess
        extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    static Optional<Student> findStudentByEmail(String email) {
        return null;
    }

    boolean existsById(Long studentId);

    void deleteById(Long studentId);

//    Student findById(Long studentId);
}
