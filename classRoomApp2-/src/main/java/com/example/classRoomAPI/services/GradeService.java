package com.example.classRoomAPI.services;

import com.example.classRoomAPI.models.Grade;
import com.example.classRoomAPI.repositories.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    IGradeRepository repository;

    //Metodo para guardar
    public Grade saveGrade( Grade datesGrade)throws Exception{
        try {

            return this.repository.save(datesGrade);

        }catch (Exception error){
            throw new Exception();
        }
    }



    //Metodo para buscarTodos


    //Metodo para buscarUnoPorId


    //Metodo para modificar


    //Metodo para eliminar


}
