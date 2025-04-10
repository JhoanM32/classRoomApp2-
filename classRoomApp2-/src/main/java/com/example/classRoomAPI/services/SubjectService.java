package com.example.classRoomAPI.services;

import com.example.classRoomAPI.models.Student;
import com.example.classRoomAPI.models.Subject;
import com.example.classRoomAPI.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    ISubjectRepository repository;

    //Metodo para guardar
    public Subject saveSubject (Subject dateSubject)throws Exception{
        try {

            return this.repository.save(dateSubject);

        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo para buscarTodos


    //Metodo para buscarUnoPorId


    //Metodo para modificar


    //Metodo para eliminar
}
