package com.example.classRoomAPI.services;

import com.example.classRoomAPI.models.Student;
import com.example.classRoomAPI.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    IStudentRepository repository;



    //Metodo para guardar
    public Student saveStudent(Student datesStudent)throws Exception{
        try {

            return this.repository.save(datesStudent);

        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo para buscarTodos


    //Metodo para buscarUnoPorId


    //Metodo para modificar


    //Metodo para eliminar

}
