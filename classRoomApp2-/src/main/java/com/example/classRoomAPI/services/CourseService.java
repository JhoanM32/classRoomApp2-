package com.example.classRoomAPI.services;


import com.example.classRoomAPI.models.Course;
import com.example.classRoomAPI.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    ICourseRepository repository;


    //Metodo para guardar
    public Course saveCourse(Course datesCourse)throws Exception{
        try {

            return this.repository.save(datesCourse);

        }catch (Exception error){
            throw new Exception();

        }
    }


    //Metodo para buscarTodos


    //Metodo para buscarUnoPorId


    //Metodo para modificar


    //Metodo para eliminar
}
