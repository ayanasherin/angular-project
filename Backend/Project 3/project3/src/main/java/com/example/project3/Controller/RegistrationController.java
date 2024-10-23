package com.example.project3.Controller;




import com.example.project3.Dto.StudentDto;
import com.example.project3.Entity.Student;
import com.example.project3.Service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@Valid @ModelAttribute StudentDto studentDto) {
        Student registeredStudent = registrationService.createRegistration(studentDto);

        // Return a JSON response for successful registration
        return ResponseEntity.status(HttpStatus.CREATED).body(new RegistrationResponse("Registered Successfully"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // A simple class to represent the JSON response for registration
    public static class RegistrationResponse {
        private String message;

        public RegistrationResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}







