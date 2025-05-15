package com.example.classRoomAPI.models;

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
    @JoinColumn(name = "fk_curso",referencedColumnName = "id_curso" )
    private Course course;

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
