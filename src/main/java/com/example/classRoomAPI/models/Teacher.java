package com.example.classRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "docente")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTeacher;
    @Column(name = "especialidad", nullable = false, length = 100)
    private  String specialty;

    //Creando relacion (1 a muchos)
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Course> cursos;


    public Teacher() {
    }

    public Teacher(Integer idTeacher, String specialty) {
        this.idTeacher = idTeacher;
        this.specialty = specialty;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Course> getCursos() {
        return cursos;
    }

    public void setCursos(List<Course> cursos) {
        this.cursos = cursos;
    }



}
