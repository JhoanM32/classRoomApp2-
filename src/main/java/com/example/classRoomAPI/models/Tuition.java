package com.example.classRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "matricula")
public class Tuition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tuitionId;
    @Column(name = "fecha_matricula", nullable = false)
    private Date tuitionDate;

    @ManyToOne
    @JoinColumn(name = "fk_course",referencedColumnName = "id_course" )
    @JsonBackReference
    private Course course;

    @ManyToOne
    @JoinColumn(name = "fk_student",referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    public Tuition() {
    }

    public Tuition(Integer tuitionId, Date tuitionDate) {
        this.tuitionId = tuitionId;
        this.tuitionDate = tuitionDate;
    }

    public Integer getTuitionId() {
        return tuitionId;
    }

    public void setTuitionId(Integer tuitionId) {
        this.tuitionId = tuitionId;
    }

    public Date getTuitionDate() {
        return tuitionDate;
    }

    public void setTuitionDate(Date tuitionDate) {
        this.tuitionDate = tuitionDate;
    }


}
