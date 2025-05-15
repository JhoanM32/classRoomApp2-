package com.example.classRoomAPI.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "estudiante")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_student")
    private Integer idStudent;
    @Column (name = "grado")
    private String grade;
    @Column (name = "fecha_nacimiento")
    private Date birthdate;
    @Column (name = "email")
    private String address;

    //Creando relacion (1 a muchos)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Attendance>attendances;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Grade>grades;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Teacher>teachers;


    public Student() {

    }

    public Student(Integer idStudent, String grade, Date birthdate, String address) {
        this.idStudent = idStudent;
        this.grade = grade;
        this.birthdate = birthdate;
        this.address = address;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
