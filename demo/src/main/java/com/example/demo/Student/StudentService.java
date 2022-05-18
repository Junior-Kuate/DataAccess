package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public record StudentService(DataAccess studentRepository) {

    @Autowired
    public StudentService {
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = DataAccess
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        Student save = DataAccess.save(student);
    }

    public void deleteStudent(Long studentId) throws IllegalAccessException {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalAccessException(
                    "student with id " + studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id" + studentId + "does not exist"));

        Thread student = null;
        if (name != null &&
                name.length() > 0) {
            assert false;
            if (!Objects.equals(student.getName(), name)) {
                student.setName(name);
            }
        }
    }
}
