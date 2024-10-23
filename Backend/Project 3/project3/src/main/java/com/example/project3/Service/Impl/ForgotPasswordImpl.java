

package com.example.project3.Service.Impl;

import com.example.project3.Entity.Student;
import com.example.project3.Repository.StudentRepository;
import com.example.project3.Service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ForgotPasswordImpl implements ForgotPasswordService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender mailSender;


    private static final long TOKEN_EXPIRY_DURATION = 60L;

    @Override
    public String generateToken(String email) {
        Student stud = studentRepository.findByEmail(email);
        if (stud == null) {
            throw new RuntimeException("User not found");
        }

        String token = UUID.randomUUID().toString();

        stud.setToken(token);

        studentRepository.save(stud);

        return token;
    }


    @Override
    public boolean resetPassword(String token, String newPassword, String confirmPassword) {
        Student stud = studentRepository.findByToken(token);
        if (stud == null) {
            throw new RuntimeException("Invalid token");
        }

        if (!newPassword.equals(confirmPassword)) {
            throw new RuntimeException("Passwords do not match");
        }

        stud.setPassword(newPassword);
        stud.setToken(null);

        studentRepository.save(stud);

        return true;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}

