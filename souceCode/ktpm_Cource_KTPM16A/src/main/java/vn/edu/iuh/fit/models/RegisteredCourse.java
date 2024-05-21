package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registered_courses")
public class RegisteredCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Integer registrationId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRegistration classRegistration;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "planned_class")
    private String plannedClass;

    @Column(name = "credits")
    private Integer credits;

    @Column(name = "practice_group")
    private String practiceGroup;

    @Column(name = "tuition_fee")
    private Double tuitionFee;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "fee_status")
    private String feeStatus;

    @Column(name = "registration_status")
    private String registrationStatus;

    // Thuộc tính mới
    @Column(name = "instructor")
    private String instructor;

    @Column(name = "schedule")
    private String schedule;

    public RegisteredCourse() {
    }

    public RegisteredCourse(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ClassRegistration getClassRegistration() {
        return classRegistration;
    }

    public void setClassRegistration(ClassRegistration classRegistration) {
        this.classRegistration = classRegistration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPlannedClass() {
        return plannedClass;
    }

    public void setPlannedClass(String plannedClass) {
        this.plannedClass = plannedClass;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPracticeGroup() {
        return practiceGroup;
    }

    public void setPracticeGroup(String practiceGroup) {
        this.practiceGroup = practiceGroup;
    }

    public Double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    // Getters và setters cho thuộc tính mới

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public RegisteredCourse(Integer registrationId, Student student, ClassRegistration classRegistration, String courseName, String plannedClass, Integer credits, String practiceGroup, Double tuitionFee, Date deadline, String feeStatus, String registrationStatus, String instructor, String schedule) {
        this.registrationId = registrationId;
        this.student = student;
        this.classRegistration = classRegistration;
        this.courseName = courseName;
        this.plannedClass = plannedClass;
        this.credits = credits;
        this.practiceGroup = practiceGroup;
        this.tuitionFee = tuitionFee;
        this.deadline = deadline;
        this.feeStatus = feeStatus;
        this.registrationStatus = registrationStatus;
        this.instructor = instructor;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "RegisteredCourse{" +
                "registrationId=" + registrationId +
                ", student=" + student +
                ", classRegistration=" + classRegistration +
                ", courseName='" + courseName + '\'' +
                ", plannedClass='" + plannedClass + '\'' +
                ", credits=" + credits +
                ", practiceGroup='" + practiceGroup + '\'' +
                ", tuitionFee=" + tuitionFee +
                ", deadline=" + deadline +
                ", feeStatus='" + feeStatus + '\'' +
                ", registrationStatus='" + registrationStatus + '\'' +
                ", instructor='" + instructor + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }
}