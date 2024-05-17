package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "credit")
    private int credit;

    @Column(name = "description")
    private String description;

    @Column(name = "lecturer")
    private String lecturer;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "prerequisites")
    private String prerequisites;

    @Column(name = "course_type")
    private String courseType;

    @Column(name = "semester")
    private int semester;

    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @Column(name = "status")
    private String status;

    @Column(name = "department")
    private String department;

    public Course() {
    }

    public Course(int courseId) {
        this.courseId = courseId;
    }

    public Course(int courseId, String courseName, int credit, String description, String lecturer, String schedule, String prerequisites, String courseType, int semester, int year, List<Enrollment> enrollments, String status, String department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.description = description;
        this.lecturer = lecturer;
        this.schedule = schedule;
        this.prerequisites = prerequisites;
        this.courseType = courseType;
        this.semester = semester;
        this.year = year;
        this.enrollments = enrollments;
        this.status = status;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", description='" + description + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", schedule='" + schedule + '\'' +
                ", prerequisites='" + prerequisites + '\'' +
                ", courseType='" + courseType + '\'' +
                ", semester=" + semester +
                ", year=" + year +
                ", enrolledStudents=" + enrollments +
                ", status='" + status + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Enrollment> getEnrolledStudents() {
        return enrollments;
    }

    public void setEnrolledStudents(List<Enrollment> enrolledStudents) {
        this.enrollments = enrollments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
