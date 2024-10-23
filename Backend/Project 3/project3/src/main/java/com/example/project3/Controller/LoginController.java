//package com.example.project3.Controller;
//
//import com.example.project3.Dto.LoginDto;
//import com.example.project3.Dto.StudentDto;
//import com.example.project3.Service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class LoginController {
//
//   @Autowired
//    private LoginService loginService;
//
//    @PostMapping("/userlogin")
//    public ResponseEntity<String> userlogin(@RequestBody StudentDto studentDTO) {
//        var user = loginService.login(studentDTO.email, studentDTO.password);
//        if(user!= null && user.getId()>0)
//        {
//            return new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
//        }
//        else
//        {
//            return new ResponseEntity<>("Logged Failed", HttpStatus.UNAUTHORIZED);
//        }
//    }
//}
package com.example.project3.Controller;

//import com.example.project3.Dto.LoginDto;
//import com.example.project3.Dto.StudentDto;
//import com.example.project3.Service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class LoginController {
//
//    @Autowired
//    private LoginService loginService;
//
//    @PostMapping("/userlogin")
//    public ResponseEntity<?> userlogin(@RequestBody StudentDto studentDTO) {
//        var user = loginService.login(studentDTO.email, studentDTO.password);
//        if (user != null && user.getId() > 0) {
//            // Return a JSON response instead of plain text
//            return ResponseEntity.ok(new LoginResponse("Logged in successfully"));
//        } else {
//            // Return JSON error response
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Login failed"));
//        }
//    }
//
//    // A simple class to represent the JSON response
//    public static class LoginResponse {
//        private String message;
//
//        public LoginResponse(String message) {
//            this.message = message;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//    }
//}


import com.example.project3.Dto.StudentDto;
import com.example.project3.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/userlogin")
    public ResponseEntity<?> userlogin(@RequestBody StudentDto studentDTO) {
        var user = loginService.login(studentDTO.getEmail(), studentDTO.getPassword());
        if (user != null && user.getId() > 0) {
            // Return the full user object including the firstname
            return ResponseEntity.ok(user);  // Return the user object directly
        } else {
            // Return a JSON error response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Login failed"));
        }
    }

    // A simple class to represent the JSON response for error messages
    public static class LoginResponse {
        private String message;

        public LoginResponse(String message) {
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
