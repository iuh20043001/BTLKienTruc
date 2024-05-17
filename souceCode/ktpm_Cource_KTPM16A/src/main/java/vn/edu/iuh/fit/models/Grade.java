package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private int gradeId;

    @Column(name = "enrollment_id")
    private int enrollmentId;

    @Column(name = "midterm")
    private float midterm;

    @Column(name = "attendance")
    private float attendance;

    @Column(name = "frequent")
    private String frequent; // JSON format or array of float

    @Column(name = "practice")
    private String practice; // JSON format or array of float

    @Column(name = "final")
    private float finalGrade;

    @Column(name = "total_score")
    private float totalScore;

    @Column(name = "gpa4")
    private float gpa4;

    @Column(name = "letter_grade")
    private String letterGrade;

    @Column(name = "ranking")
    private String ranking;

    @Column(name = "note")
    private String note;

    @Column(name = "avg_score")
    private float avgScore;

    @Column(name = "pass")
    private boolean pass;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public float getMidterm() {
        return midterm;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public float getAttendance() {
        return attendance;
    }

    public void setAttendance(float attendance) {
        this.attendance = attendance;
    }

    public String getFrequent() {
        return frequent;
    }

    public void setFrequent(String frequent) {
        this.frequent = frequent;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public float getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(float finalGrade) {
        this.finalGrade = finalGrade;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public float getGpa4() {
        return gpa4;
    }

    public void setGpa4(float gpa4) {
        this.gpa4 = gpa4;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public String getRank() {
        return ranking;
    }

    public void setRank(String rank) {
        this.ranking = rank;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public Grade() {
    }

    public Grade(int gradeId) {
        this.gradeId = gradeId;
    }

    public Grade(int gradeId, int enrollmentId, float midterm, float attendance, String frequent, String practice, float finalGrade, float totalScore, float gpa4, String letterGrade, String ranking, String note, float avgScore, boolean pass) {
        this.gradeId = gradeId;
        this.enrollmentId = enrollmentId;
        this.midterm = midterm;
        this.attendance = attendance;
        this.frequent = frequent;
        this.practice = practice;
        this.finalGrade = finalGrade;
        this.totalScore = totalScore;
        this.gpa4 = gpa4;
        this.letterGrade = letterGrade;
        this.ranking = ranking;
        this.note = note;
        this.avgScore = avgScore;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "gradeId=" + gradeId +
                ", enrollmentId=" + enrollmentId +
                ", midterm=" + midterm +
                ", attendance=" + attendance +
                ", frequent='" + frequent + '\'' +
                ", practice='" + practice + '\'' +
                ", finalGrade=" + finalGrade +
                ", totalScore=" + totalScore +
                ", gpa4=" + gpa4 +
                ", letterGrade='" + letterGrade + '\'' +
                ", rank='" + ranking + '\'' +
                ", note='" + note + '\'' +
                ", avgScore=" + avgScore +
                ", pass=" + pass +
                '}';
    }
}
