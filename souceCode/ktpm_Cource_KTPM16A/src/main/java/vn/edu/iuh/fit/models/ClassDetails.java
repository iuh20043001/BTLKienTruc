package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "class_details")
public class ClassDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer detailId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRegistration classRegistration;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "practice_group")
    private String practiceGroup;

    @Column(name = "room")
    private String room;

    @Column(name = "building")
    private String building;

    @Column(name = "campus")
    private String campus;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "time")
    private String time;

    @Override
    public String toString() {
        return "ClassDetails{" +
                "detailId=" + detailId +
                ", classRegistration=" + classRegistration +
                ", schedule='" + schedule + '\'' +
                ", practiceGroup='" + practiceGroup + '\'' +
                ", room='" + room + '\'' +
                ", building='" + building + '\'' +
                ", campus='" + campus + '\'' +
                ", instructor='" + instructor + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public ClassDetails() {
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public ClassRegistration getClassRegistration() {
        return classRegistration;
    }

    public void setClassRegistration(ClassRegistration classRegistration) {
        this.classRegistration = classRegistration;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPracticeGroup() {
        return practiceGroup;
    }

    public void setPracticeGroup(String practiceGroup) {
        this.practiceGroup = practiceGroup;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ClassDetails(Integer detailId, ClassRegistration classRegistration, String schedule, String practiceGroup, String room, String building, String campus, String instructor, String time) {
        this.detailId = detailId;
        this.classRegistration = classRegistration;
        this.schedule = schedule;
        this.practiceGroup = practiceGroup;
        this.room = room;
        this.building = building;
        this.campus = campus;
        this.instructor = instructor;
        this.time = time;
    }

    public ClassDetails(Integer detailId) {
        this.detailId = detailId;
    }
// Constructors, getters, setters, toString method
}
