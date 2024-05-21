package vn.edu.iuh.fit.models;

public class CurriculumCourse {
    private String courseCode;
    private int stt;
    private String courseName;
    private int courseId;
    private String companion;
    private String prerequisites;
    private int credits;
    private int lectureHours;
    private int labHours;
    private String passStatus;
    private String syllabus;

    public CurriculumCourse(String courseCode, int stt, String courseName, int courseId, String companion, String prerequisites, int credits, int lectureHours, int labHours, String passStatus, String syllabus) {
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
                "courseCode='" + courseCode + '\'' +
                ", stt=" + stt +
                ", courseName='" + courseName + '\'' +
                ", courseId=" + courseId +
                ", companion='" + companion + '\'' +
                ", prerequisites='" + prerequisites + '\'' +
                ", credits=" + credits +
                ", lectureHours=" + lectureHours +
                ", labHours=" + labHours +
                ", passStatus='" + passStatus + '\'' +
                ", syllabus='" + syllabus + '\'' +
                '}';
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
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

    public int getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
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
}

