package com.example.classRoomAPI.models;

import com.example.classRoomAPI.helpers.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "asistencia")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAttendance;


    @Column(name = "fecha")
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Status status;

    //creando realacion (muchos a 1)
    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_course",referencedColumnName = "id_course" )
    @JsonBackReference
    private Course course;



    public Attendance() {
    }

    public Attendance(Integer idAttendance, Date date, Status status) {
        this.idAttendance = idAttendance;
        this.date = date;
        this.status = status;
    }

    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
