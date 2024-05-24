package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
public class CurriculumCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Sửa thành kiểu dữ liệu phù hợp với cơ sở dữ liệu của bạn, ví dụ: Long

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "stt")
    private String stt;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "companion")
    private String companion;

    @Column(name = "prerequisites")
    private String prerequisites;

    @Column(name = "credits")
    private int credits;

    @Column(name = "lecture_hours")
    private String lectureHours;

    @Column(name = "lab_hours")
    private String labHours;

    @Column(name = "pass_status")
    private String passStatus;

    @Column(name = "syllabus")
    private String syllabus;

    public CurriculumCourse() {
    }

    public CurriculumCourse(int id) {
        this.id = id;
    }

    public CurriculumCourse(int id, String courseCode, String stt, String courseName, String courseId, String companion, String prerequisites, int credits, String lectureHours, String labHours, String passStatus, String syllabus) {
        this.id = id;
        this.courseCode = courseCode;
        this.stt = stt;
        this.courseName = courseName;
        this.courseId = courseId;
        this.companion = companion;
        this.prerequisites = prerequisites;
        this.credits = credits;
        this.lectureHours = lectureHours;
        this.labHours = labHours;
        this.passStatus = passStatus;
        this.syllabus = syllabus;
    }

    @Override
    public String toString() {
        return "CurriculumCourse{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", stt='" + stt + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", companion='" + companion + '\'' +
                ", prerequisites='" + prerequisites + '\'' +
                ", credits=" + credits +
                ", lectureHours='" + lectureHours + '\'' +
                ", labHours='" + labHours + '\'' +
                ", passStatus='" + passStatus + '\'' +
                ", syllabus='" + syllabus + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(String lectureHours) {
        this.lectureHours = lectureHours;
    }

    public String getLabHours() {
        return labHours;
    }

    public void setLabHours(String labHours) {
        this.labHours = labHours;
    }

    public String getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(String passStatus) {
        this.passStatus = passStatus;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    // Constructors, getters, setters, and toString method
}
