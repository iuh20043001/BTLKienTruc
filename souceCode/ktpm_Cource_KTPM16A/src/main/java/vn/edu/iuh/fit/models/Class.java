package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "name", nullable = false)
    private String name;

    public Class() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class(Integer classId, String name) {
        this.classId = classId;
        this.name = name;
    }

    public Class(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", name='" + name + '\'' +
                '}';
    }

    // Constructors, getters, setters, toString method
}
