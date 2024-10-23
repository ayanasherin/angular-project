package com.example.project3.Dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class StudentDto {
    private int id;


//    @NotEmpty(message = "Prefix is Required")
//    @Pattern(regexp = "^[A-Za-z]{2,4}")
    private String prefix;

//    @Pattern(regexp = "^[A-Za-z]+$")
    private String firstname;

//    @Pattern(regexp = "^[A-Za-z]+$")
    private String lastname;

//    @NotEmpty(message = "Address is Required")
    private String addressline1;

//    @NotEmpty(message = "Address is Required")
    private String adressline2;

//    @NotEmpty(message = "City is Required")
    private String city;

//    @NotEmpty(message = "State is Required")
    private String state;

//    @NotEmpty(message = "Postal code is required")
//    @Pattern(regexp = "^\\+?[0-9.()-]{6}", message="Zip code is invalid")
    private String zipcode;

//    @NotEmpty(message = "Country code is required")
//    @Pattern(regexp="^(\\+?\\d{1,3}|\\d{1,4})$", message="Country code is invalid")
    private String countrycode;


//    @NotEmpty(message = "Phone number is required")
//    @Pattern(regexp="^\\+?[0-9.()-]{10}", message="Phone number is invalid")
    private String phone;


//    @NotEmpty(message="Email is required")
//    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="E-mail is invalid")
    public String email;

//    @NotEmpty(message = "Password is required")
//    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}",message = "Password must be at least 8 characters long, contain at least one letter, one number and one special character")
    public String password;
    private String BachelorDegree;

    private double BachelorGPA;


    private String Md;

    private double MdGPA;
    private Boolean LookingForInternship;

    public StudentDto(String token, Boolean lookingForInternship, double mdGPA, String md, double bachelorGPA, String bachelorDegree, String password, String email, String phone, String countrycode, String zipcode, String state, String city, String adressline2, String addressline1, String lastname, String firstname, String prefix, int id,MultipartFile resume) {
        this.id = id;
        this.lastname = lastname;
        this.prefix = prefix;
        this.firstname = firstname;
        this.addressline1 = addressline1;
        this.adressline2 = adressline2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.countrycode = countrycode;
        this.phone = phone;
        this.email = email;
        this.password = password;
        BachelorDegree = bachelorDegree;
        BachelorGPA = bachelorGPA;
        Md = md;
        MdGPA = mdGPA;
        LookingForInternship = lookingForInternship;
        this.token = token;
        this.resume = resume;
    }

    private enum LearnedAboutUs{
        Friend,
        INTERNET,
        MEDIA,
        EVENT;
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
        BachelorDegree = bachelorDegree;
    }

    public double getBachelorGPA() {
        return BachelorGPA;
    }

    public void setBachelorGPA(double bachelorGPA) {
        BachelorGPA = bachelorGPA;
    }

    public String getMd() {
        return Md;
    }

    public void setMd(String md) {
        Md = md;
    }

    public double getMdGPA() {
        return MdGPA;
    }

    public void setMdGPA(double mdGPA) {
        MdGPA = mdGPA;
    }

    public Boolean getLookingForInternship() {
        return LookingForInternship;
    }

    public void setLookingForInternship(Boolean lookingForInternship) {
        LookingForInternship = lookingForInternship;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public MultipartFile getResume() {
        return resume;
    }

    public void setResume(MultipartFile resume) {
        this.resume = resume;
    }

    //private String Resume;
    private MultipartFile resume;
 //private MultipartFile resume;


    public StudentDto(int id, String lastname, String prefix, String firstname, String addressline1, String adressline2, String city, String state, String zipcode, String countrycode, String phone, String email, String password, String bachelorDegree, double bachelorGPA, String md, double mdGPA, Boolean lookingForInternship, String token,MultipartFile resume) {
        this.id = id;
        this.lastname = lastname;
        this.prefix = prefix;
        this.firstname = firstname;
        this.addressline1 = addressline1;
        this.adressline2 = adressline2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.countrycode = countrycode;
        this.phone = phone;
        this.email = email;
        this.password = password;
        BachelorDegree = bachelorDegree;
        BachelorGPA = bachelorGPA;
        Md = md;
        MdGPA = mdGPA;
        LookingForInternship = lookingForInternship;
        this.token = token;
        this.resume =resume;
    }
    public StudentDto() {
        // Default constructor
    }

    //    public MultipartFile getResume() {
//        return resume;
//    }
//
//    public void setResume(MultipartFile resume) {
//        this.resume = resume;
//    }


//    public StudentDto(int id, String prefix, String firstname, String lastname, String addressline1, String adressline2, String city, String state, String zipcode, String countrycode, String phone, String email, String password, String bachelorDegree, double bachelorGPA, String md, double mdGPA, boolean lookingForInternship, String token) {
//        this.id = id;
//        this.prefix = prefix;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.addressline1 = addressline1;
//        this.adressline2 = adressline2;
//        this.city = city;
//        this.state = state;
//        this.zipcode = zipcode;
//        this.countrycode = countrycode;
//        this.phone = phone;
//        this.email = email;
//        this.password = password;
//        BachelorDegree = bachelorDegree;
//        BachelorGPA = bachelorGPA;
//        Md = md;
//        MdGPA = mdGPA;
//        LookingForInternship = lookingForInternship;
//        this.token = token;
//    }


}

