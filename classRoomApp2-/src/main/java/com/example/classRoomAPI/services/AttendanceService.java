package com.example.classRoomAPI.services;


import com.example.classRoomAPI.models.Attendance;
import com.example.classRoomAPI.repositories.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    IAttendanceRepository repository;


    //Metodo para guardar
    public Attendance saveAttendance(Attendance datesAttendance) throws Exception{
        try {

            return this.repository.save(datesAttendance);

        }catch (Exception error){
            throw new Exception();

        }
    }


    //Metodo para buscarTodos


    //Metodo para buscarUnoPorId


    //Metodo para modificar


    //Metodo para eliminar


}
