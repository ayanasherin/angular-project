package com.example.project3.Service.Impl;

import com.example.project3.Dto.StudentDto;
import com.example.project3.Entity.Student;
import com.example.project3.Repository.StudentRepository;
import com.example.project3.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createRegistration(StudentDto registrationDto) {
        Student student = new Student();
        student.setPrefix(registrationDto.getPrefix());
        student.setFirstname(registrationDto.getFirstname());
        student.setLastname(registrationDto.getLastname());
        student.setAddressline1(registrationDto.getAddressline1());
        student.setAdressline2(registrationDto.getAdressline2());
        student.setCity(registrationDto.getCity());
        student.setState(registrationDto.getState());
        student.setZipcode(registrationDto.getZipcode());
        student.setCountrycode(registrationDto.getCountrycode());
        student.setPhone(registrationDto.getPhone());
        student.setEmail(registrationDto.getEmail());
        student.setPassword(registrationDto.getPassword());
        student.setBachelorDegree(registrationDto.getBachelorDegree());
        student.setBachelorGPA(registrationDto.getBachelorGPA());
        student.setMd(registrationDto.getMd());
        student.setMdGPA(registrationDto.getMdGPA());
        student.setLookingForInternship(registrationDto.getLookingForInternship());
        student.setToken(registrationDto.getToken());

        // Convert MultipartFile to byte[] and store it
        try {
            byte[] resumeFile = registrationDto.getResume().getBytes();
            student.setResume(resumeFile);  // Store byte[] in student entity
        } catch (IOException e) {
            e.printStackTrace();  // Handle IOException if any
        }

        return studentRepository.save(student);
    }
}
