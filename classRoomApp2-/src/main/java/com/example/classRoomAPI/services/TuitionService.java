package com.example.classRoomAPI.services;


import com.example.classRoomAPI.models.Tuition;
import com.example.classRoomAPI.repositories.ITuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuitionService {

    @Autowired
    ITuitionRepository repository;

    //Metodo para guardar
    public Tuition saveTuition(Tuition dateTuition)throws Exception{
        try {

            return this.repository.save(dateTuition);

        }catch (Exception error){
            throw new Exception();

        }
    }

    //Metodo para buscarTodos


    //Metodo para buscarUnoPorId


    //Metodo para modificar


    //Metodo para eliminar
}
