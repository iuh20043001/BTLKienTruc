package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "credits")
    private Integer credits;

    @Column(name = "prerequisite_courses")
    private String prerequisiteCourses;

    @Column(name = "max_students")
    private Integer maxStudents;

    @OneToMany(mappedBy = "course")
    private List<ClassRegistration> classRegistrations;

    // Constructors, getters, setters, toString method

    public Course() {}

    public Course(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", prerequisiteCourses='" + prerequisiteCourses + '\'' +
                ", maxStudents=" + maxStudents +
                ", classRegistrations=" + classRegistrations +
                '}';
    }

    // Getters and setters

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(String prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }

    public Integer getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Course(Integer courseId, String courseCode, String courseName, Integer credits, String prerequisiteCourses, Integer maxStudents, List<ClassRegistration> classRegistrations) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.prerequisiteCourses = prerequisiteCourses;
        this.maxStudents = maxStudents;
        this.classRegistrations = classRegistrations;
    }
}
