package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    @Column(name = "enrollment_year")
    private Integer enrollmentYear;

    @Column(name = "education_level")
    private String educationLevel;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "training_type")
    private String trainingType;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "campus")
    private String campus;

    @Column(name = "credits_registered")
    private Integer creditsRegistered;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "graduation_info")
    private String graduationInfo;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Integer getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Integer getCreditsRegistered() {
        return creditsRegistered;
    }

    public void setCreditsRegistered(Integer creditsRegistered) {
        this.creditsRegistered = creditsRegistered;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getGraduationInfo() {
        return graduationInfo;
    }

    public void setGraduationInfo(String graduationInfo) {
        this.graduationInfo = graduationInfo;
    }

    public Student(Integer studentId, String name, Date birthdate, String address, String email, String phoneNumber, Major major, Class clazz, Integer enrollmentYear, String educationLevel, Department department, String trainingType, String specialization, String campus, Integer creditsRegistered, Double gpa, String graduationInfo) {
        this.studentId = studentId;
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.clazz = clazz;
        this.enrollmentYear = enrollmentYear;
        this.educationLevel = educationLevel;
        this.department = department;
        this.trainingType = trainingType;
        this.specialization = specialization;
        this.campus = campus;
        this.creditsRegistered = creditsRegistered;
        this.gpa = gpa;
        this.graduationInfo = graduationInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", major=" + major +
                ", clazz=" + clazz +
                ", enrollmentYear=" + enrollmentYear +
                ", educationLevel='" + educationLevel + '\'' +
                ", department=" + department +
                ", trainingType='" + trainingType + '\'' +
                ", specialization='" + specialization + '\'' +
                ", campus='" + campus + '\'' +
                ", creditsRegistered=" + creditsRegistered +
                ", gpa=" + gpa +
                ", graduationInfo='" + graduationInfo + '\'' +
                '}';
    }
// Constructors, getters, setters, toString method
}
