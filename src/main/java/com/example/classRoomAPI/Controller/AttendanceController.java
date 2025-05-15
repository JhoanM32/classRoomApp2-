package com.example.classRoomAPI.Controller;


import com.example.classRoomAPI.models.Attendance;

import com.example.classRoomAPI.service.AttendanceService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Registered
@RequestMapping("/asistencias")
public class AttendanceController {

    @Autowired
    AttendanceService service;

    //guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Attendance datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveAttendance(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    //buscartodos

    //buscarPorid


    //modificar


}
