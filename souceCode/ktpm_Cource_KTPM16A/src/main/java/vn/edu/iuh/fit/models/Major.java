package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "majors")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private Integer majorId;

    @Column(name = "major_code", nullable = false)
    private String majorCode;

    @Column(name = "major_name", nullable = false)
    private String majorName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "graduation_requirements")
    private String graduationRequirements;

    public Major() {
    }

    public Major(Integer majorId) {
        this.majorId = majorId;
    }

    public Major(Integer majorId, String majorCode, String majorName, Department department, String graduationRequirements) {
        this.majorId = majorId;
        this.majorCode = majorCode;
        this.majorName = majorName;
        this.department = department;
        this.graduationRequirements = graduationRequirements;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getGraduationRequirements() {
        return graduationRequirements;
    }

    public void setGraduationRequirements(String graduationRequirements) {
        this.graduationRequirements = graduationRequirements;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorCode='" + majorCode + '\'' +
                ", majorName='" + majorName + '\'' +
                ", department=" + department +
                ", graduationRequirements='" + graduationRequirements + '\'' +
                '}';
    }
// Constructors, getters, setters, toString method
}
