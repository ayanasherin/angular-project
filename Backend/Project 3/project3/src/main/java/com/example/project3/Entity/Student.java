package com.example.project3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
    @Table(name = "Student")
    @Data
    public class Student {
        @Id
        @Column(nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(nullable = false, length = 10)
//        @NotEmpty(message = "Prefix is Required")
//        @Pattern(regexp = "^[A-Za-z]{2,4}")
        private String prefix;

        @Column(length = 45, nullable = false)
//        @Pattern(regexp = "^[A-Za-z]+$")
        private String firstname;

        @Column(length = 45, nullable = false)
//        @Pattern(regexp = "^[A-Za-z]+$")
        private String lastname;

        @Column(length = 55, nullable = false)
//        @NotEmpty(message = "Address is Required")
        private String addressline1;

        @Column(length = 55, nullable = false)
//        @NotEmpty(message = "Address is Required")
        private String adressline2;

        @Column(length = 55, nullable = false)
//        @NotEmpty(message = "City is Required")
        private String city;

        @Column(length = 55, nullable = false)
//        @NotEmpty(message = "State is Required")
        private String state;

        @Column(length = 10, nullable = false)
//        @NotEmpty(message = "Postal code is required")
//        @Pattern(regexp = "^\\+?[0-9.()-]{6}", message="Zip code is invalid")
        private String zipcode;

        @Column(length = 5 ,nullable = false)
//        @NotEmpty(message = "Country code is required")
//        @Pattern(regexp="^(\\+?\\d{1,3}|\\d{1,4})$", message="Country code is invalid")
        private String countrycode;


        @Column(unique = true, length = 100, nullable = false)
//        @NotEmpty(message = "Phone number is required")
//        @Pattern(regexp="^\\+?[0-9.()-]{10}", message="Phone number is invalid")
        private String phone;


        @Column(unique = true, length = 100, nullable = false)
//        @NotEmpty(message="Email is required")
//        @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="E-mail is invalid")
        private String email;

        @Column(length = 55, nullable = false)
        private String password;

        @Column(length = 55)
        private String BachelorDegree;

        private double BachelorGPA;
        @Column(length = 55)
        private String Md;

        private double MdGPA;
        private Boolean LookingForInternship;
//        private enum LearnedAboutUs{
//            Friend,
//            INTERNET,
//            MEDIA,
//            EVENT;
//        }
        private String token;
       private byte[] resume;


        public Student() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getAddressline1() {
            return addressline1;
        }

        public void setAddressline1(String addressline1) {
            this.addressline1 = addressline1;
        }

        public String getAdressline2() {
            return adressline2;
        }

        public void setAdressline2(String adressline2) {
            this.adressline2 = adressline2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getCountrycode() {
            return countrycode;
        }

        public void setCountrycode(String countrycode) {
            this.countrycode = countrycode;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getBachelorDegree() {
            return BachelorDegree;
        }

        public void setBachelorDegree(String bachelorDegree) {
            this.BachelorDegree = bachelorDegree;
        }

        public double getBachelorGPA() {
            return BachelorGPA;
        }

        public void setBachelorGPA(double bachelorGPA) {
            this.BachelorGPA = bachelorGPA;
        }

        public String getMd() {
            return Md;
        }

        public void setMd(String md) {
            this.Md = md;
        }

        public double getMdGPA() {
            return MdGPA;
        }

        public void setMdGPA(double mdGPA) {
            this.MdGPA = mdGPA;
        }

        public Boolean getLookingForInternship() {
            return LookingForInternship;
        }

        public void setLookingForInternship(Boolean lookingForInternship) {
            this.LookingForInternship = lookingForInternship;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

//    public byte[] getResume() {
//        return resume;
//    }
//
//    public void setResume(byte[] resume) {
//        this.resume = resume;
//    }

        public Student(int id, String prefix, String firstname, String lastname, String addressline1, String adressline2, String city, String state, String zipcode, String countrycode, String phone, String email, String password, String bachelorDegree, double bachelorGPA, String md, double mdGPA, Boolean lookingForInternship, String token,byte[] resume) {
            this.id = id;
            this.prefix = prefix;
            this.firstname = firstname;
            this.lastname = lastname;
            this.addressline1 = addressline1;
            this.adressline2 = adressline2;
            this.city = city;
            this.state = state;
            this.zipcode = zipcode;
            this.countrycode = countrycode;
            this.phone = phone;
            this.email = email;
            this.password = password;
            this.BachelorDegree = bachelorDegree;
            this.BachelorGPA = bachelorGPA;
            this.Md = md;
            this.MdGPA = mdGPA;
            this.LookingForInternship = lookingForInternship;
            this.token = token;
            this.resume = resume;
        }
    }


