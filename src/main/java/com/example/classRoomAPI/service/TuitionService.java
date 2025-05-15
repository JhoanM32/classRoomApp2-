package com.example.classRoomAPI.service;

import com.example.classRoomAPI.helpers.MessagesApi;
import com.example.classRoomAPI.models.Grade;
import com.example.classRoomAPI.models.Teacher;
import com.example.classRoomAPI.models.Tuition;
import com.example.classRoomAPI.repositories.ITuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TuitionService {

    @Autowired
    ITuitionRepository repository;

    //Metodo para guardar
    public Tuition saveTuition(Tuition dateTuition)throws Exception{
        try{

            return this.repository.save(dateTuition);

        }catch (Exception Error){
            throw new Exception();
        }
    }

    //Metodo para buscarTodos
    public List<Tuition>ListTuitions()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }


    //Metodo para buscarUnoPorId
    public Tuition buscarMatriculaPorId(Integer id)throws Exception{
        try {
            Optional<Tuition>tuitionQueEstoyBuscando= this.repository.findById(id);
            if (tuitionQueEstoyBuscando.isPresent()){
                return tuitionQueEstoyBuscando.get();
            }else {
                throw new Exception(MessagesApi.ERROR_GRADE_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Tuition modificarCalificacion(Integer id, Tuition datosNuevosTuition)throws Exception{
        try {
            Optional<Tuition> tuitionQueEstoyBuscandoParaEditar= this.repository.findById(id);
            if (tuitionQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico esa matriculas
                tuitionQueEstoyBuscandoParaEditar.get().setTuitionDate(datosNuevosTuition.getTuitionDate());
                //guardo las modificaciones en BD
                return this.repository.save(tuitionQueEstoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MessagesApi.ERROR_TUITION_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
}
