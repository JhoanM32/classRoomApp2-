package com.example.classRoomAPI.service;

import com.example.classRoomAPI.helpers.MessagesApi;
import com.example.classRoomAPI.models.Attendance;
import com.example.classRoomAPI.models.Teacher;
import com.example.classRoomAPI.repositories.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    IAttendanceRepository repository;


    //Metodo para guardar
    public Attendance saveAttendance(Attendance dateAttendance) throws Exception{
        try {

            return this.repository.save(dateAttendance);

        }catch (Exception error){
            throw new Exception();

        }
    }


    //Metodo para buscarTodos
    public List<Attendance>ListAttendances()throws Exception{
        try{

            return this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }


    //Metodo para buscarUnoPorId
    public Attendance buscarAsistenciaPorId(Integer id)throws Exception{
        try {
            Optional<Attendance>attendanceQueEStoyBuscando=this.repository.findById(id);
            if (attendanceQueEStoyBuscando.isPresent()){
                return attendanceQueEStoyBuscando.get();

            }else {
                throw new Exception(MessagesApi.ERROR_ATTENDANCE_NO_ENCONTRADO.getMenssages());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Attendance modificarAsistencia(Integer id, Attendance datosNuevosAttendance)throws Exception{
        try {
            Optional<Attendance>attendanceQueEstoyBuscandoParaEditar=this.repository.findById(id);
            if (attendanceQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico esa asistencia
                attendanceQueEstoyBuscandoParaEditar.get().setDate(datosNuevosAttendance.getDate());
                attendanceQueEstoyBuscandoParaEditar.get().setStatus(datosNuevosAttendance.getStatus());
                //guardo las modificaciones en BD
                return this.repository.save(attendanceQueEstoyBuscandoParaEditar.get());


            }else {
                throw new Exception(MessagesApi.ERROR_ATTENDANCE_NO_ENCONTRADO.getMenssages());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar



}
