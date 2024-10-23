package com.example.project3.Service.Impl;

import com.example.project3.Dto.StudentDto;
import com.example.project3.Entity.Student;
import com.example.project3.Repository.StudentRepository;
import com.example.project3.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto login(String email, String password) {

        Student student = studentRepository.findByEmailAndPassword(email, password);

        if (student != null) {

            return mapToDto(student);
        } else {

            return null;
        }
    }

private StudentDto mapToDto(Student student) {

    return new StudentDto(
            student.getToken(),
            student.getLookingForInternship(),
            student.getMdGPA(),
                student.getMd(),
                student.getBachelorGPA(),
                student.getBachelorDegree(),
                student.getPassword(),
                student.getEmail(),
                student.getPhone(),
                student.getCountrycode(),
                student.getZipcode(),
                student.getState(),
                student.getCity(),
                student.getAdressline2(),
                student.getAddressline1(),
                student.getLastname(),
                student.getFirstname(),
                student.getPrefix(),
                student.getId(),
                null
            );
}
//    private StudentDto mapToDto(Student student) {
//        return new StudentDto(
//                student.getToken(),
//                student.getLookingForInternship(),
//                student.getMdGPA(),
//                student.getMd(),
//                student.getBachelorGPA(),
//                student.getBachelorDegree(),
//                student.getPassword(),
//                student.getEmail(),
//                student.getPhone(),
//                student.getCountrycode(),
//                student.getZipcode(),
//                student.getState(),
//                student.getCity(),
//                student.getAdressline2(),
//                student.getAddressline1(),
//                student.getLastname(),
//                student.getFirstname(),
//                student.getPrefix(),
//                student.getId()
                // student.getResume()
//        );
    }


