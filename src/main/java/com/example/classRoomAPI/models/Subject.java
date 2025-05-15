package com.example.classRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_subject")
    private Integer subjectId;
    @Column (name = "nombre")
    private String name;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference
    private List<Grade>calificaciones;

    public Subject() {
    }

    public Subject(Integer subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Grade> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Grade> calificaciones) {
        this.calificaciones = calificaciones;
    }

}
