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

    @Column(name = "companion")
    private String companion;

    @Column(name = "syllabus")
    private String syllabus;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClassRegistration> classRegistrations;

    // Constructors
    public Course() {}

    public Course(Integer courseId, String courseCode, String courseName, Integer credits, String prerequisiteCourses, Integer maxStudents, String companion, String syllabus, List<ClassRegistration> classRegistrations) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.prerequisiteCourses = prerequisiteCourses;
        this.maxStudents = maxStudents;
        this.companion = companion;
        this.syllabus = syllabus;
        this.classRegistrations = classRegistrations;
    }

    // Getters and Setters
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

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public List<ClassRegistration> getClassRegistrations() {
        return classRegistrations;
    }

    public void setClassRegistrations(List<ClassRegistration> classRegistrations) {
        this.classRegistrations = classRegistrations;
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
                ", companion='" + companion + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", classRegistrations=" + classRegistrations +
                '}';
    }
}
