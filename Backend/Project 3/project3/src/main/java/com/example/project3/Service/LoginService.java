package com.example.project3.Service;

import com.example.project3.Dto.StudentDto;

public interface LoginService {
    StudentDto  login(String email, String password);
}
