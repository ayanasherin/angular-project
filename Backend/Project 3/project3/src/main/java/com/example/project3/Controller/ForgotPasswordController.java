package com.example.project3.Controller;
import com.example.project3.Service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")

public class ForgotPasswordController {
    @Autowired
    private ForgotPasswordService forgotPasswordService;


    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String token = forgotPasswordService.generateToken(email);


        String resetLink = "http://localhost:4200/resetpassword?token="+token;
        String subject = "Password Reset Request";
        String body = "To reset your password, please click the following link: " + resetLink;

        forgotPasswordService.sendEmail(email, subject, body);

        return ResponseEntity.ok("Password reset link sent to your email.");
    }


    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestBody Map<String, String> payload) {
        String token = payload.get("token");
        String newPassword = payload.get("newPassword");
        String confirmPassword = payload.get("confirmPassword");

        boolean success = forgotPasswordService.resetPassword(token, newPassword, confirmPassword);
        if (success) {
            Map<String, String> response = Map.of("message", "Password reset successful.");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> error = Map.of("error", "Invalid or expired token, or passwords do not match.");
            return ResponseEntity.badRequest().body(error);
        }
    }



}


