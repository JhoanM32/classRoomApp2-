package com.example.classRoomAPI.models;

import com.example.classRoomAPI.helpers.Status;

import java.util.Date;

public class Attendance {
    private Integer idAttendance;
    private Date date;
    private Status status;

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
}
