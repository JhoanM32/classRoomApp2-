package com.example.classRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "materia")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_subject")
    private Integer subjectId;
    @Column (name = "nombre")
    private String name;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference
    private List<Grade>grades;

    @ManyToOne
    @JoinColumn(name = "fk_course",referencedColumnName = "id_course" )
    @JsonBackReference
    private Course course;

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


    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
