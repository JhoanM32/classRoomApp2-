package com.example.classRoomAPI.Controller;


import com.example.classRoomAPI.models.Course;
import com.example.classRoomAPI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CourseController {
    @Autowired
    CourseService service;

    //guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Course datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveCourse(datosQueEnviaElCliente));

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
