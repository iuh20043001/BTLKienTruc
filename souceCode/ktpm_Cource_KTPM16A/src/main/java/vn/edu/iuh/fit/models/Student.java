package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "enrollment_date")
    private Date enrollmentDate;

    @Column(name = "major")
    private String major;

    @Column(name = "year")
    private int year;

    @Column(name = "current_semester")
    private int currentSemester;

    @Column(name = "gpa")
    private float gpa;

    @Column(name = "status")
    private String status;

    @Column(name = "credits_earned")
    private int creditsEarned;

    @Column(name = "scholarship_status")
    private String scholarshipStatus;

    @Column(name = "advisor")
    private String advisor;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;


    public Student() {
    }

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public Student(int studentId, String name, String email, Date dateOfBirth, String address, String phoneNumber, String gender, Date enrollmentDate, String major, int year, int currentSemester, float gpa, String status, int creditsEarned, String scholarshipStatus, String advisor, List<Enrollment> enrollments) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.enrollmentDate = enrollmentDate;
        this.major = major;
        this.year = year;
        this.currentSemester = currentSemester;
        this.gpa = gpa;
        this.status = status;
        this.creditsEarned = creditsEarned;
        this.scholarshipStatus = scholarshipStatus;
        this.advisor = advisor;
        this.enrollments = enrollments;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(int creditsEarned) {
        this.creditsEarned = creditsEarned;
    }

    public String getScholarshipStatus() {
        return scholarshipStatus;
    }

    public void setScholarshipStatus(String scholarshipStatus) {
        this.scholarshipStatus = scholarshipStatus;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public List<Enrollment> getCoursesEnrolled() {
        return enrollments;
    }

    public void setCoursesEnrolled(List<Enrollment> coursesEnrolled) {
        this.enrollments = coursesEnrolled;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", major='" + major + '\'' +
                ", year=" + year +
                ", currentSemester=" + currentSemester +
                ", gpa=" + gpa +
                ", status='" + status + '\'' +
                ", creditsEarned=" + creditsEarned +
                ", scholarshipStatus='" + scholarshipStatus + '\'' +
                ", advisor='" + advisor + '\'' +
                ", coursesEnrolled=" + enrollments +
                '}';
    }
}
