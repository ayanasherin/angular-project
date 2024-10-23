package com.example.project3.Service;

public interface ForgotPasswordService {
    String generateToken(String email);
    boolean resetPassword(String token, String newPassword, String confirmPassword);
    void sendEmail(String to, String subject, String body);

}
