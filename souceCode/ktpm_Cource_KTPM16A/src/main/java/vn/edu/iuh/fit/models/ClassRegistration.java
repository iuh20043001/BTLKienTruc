package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "class_registration")
public class ClassRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnoreProperties("classRegistrations")
    private Course course;

    @Column(name = "class_code", nullable = false)
    private String classCode;

    @Column(name = "class_name")
    private String className;

    @Column(name = "planned_class")
    private String plannedClass;

    @Column(name = "max_capacity")
    private Integer maxCapacity;

    @Column(name = "registered_students")
    private Integer registeredStudents;

    @Column(name = "status")
    private String status;

    // Constructors
    public ClassRegistration() {}

    public ClassRegistration(Integer classId, Course course, String classCode, String className, String plannedClass, Integer maxCapacity, Integer registeredStudents, String status) {
        this.classId = classId;
        this.course = course;
        this.classCode = classCode;
        this.className = className;
        this.plannedClass = plannedClass;
        this.maxCapacity = maxCapacity;
        this.registeredStudents = registeredStudents;
        this.status = status;
    }

    // Getters and Setters
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPlannedClass() {
        return plannedClass;
    }

    public void setPlannedClass(String plannedClass) {
        this.plannedClass = plannedClass;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Integer registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassRegistration{" +
                "classId=" + classId +
                ", course=" + course +
                ", classCode='" + classCode + '\'' +
                ", className='" + className + '\'' +
                ", plannedClass='" + plannedClass + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", registeredStudents=" + registeredStudents +
                ", status='" + status + '\'' +
                '}';
    }
}
