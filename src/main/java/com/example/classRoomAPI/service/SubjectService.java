package com.example.classRoomAPI.service;


import com.example.classRoomAPI.helpers.MessagesApi;
import com.example.classRoomAPI.models.Subject;
import com.example.classRoomAPI.models.Teacher;
import com.example.classRoomAPI.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    ISubjectRepository repository;


    //Metodo para guardar
    public Subject saveSubject(Subject dateSubject)throws Exception{
        try{

            return this.repository.save(dateSubject);

        }catch (Exception Error) {
            throw new Exception();
        }
    }
    //Metodo para buscarTodos
    public List<Subject>ListSubjecs()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }


    //Metodo para buscarUnoPorId
    public Subject buscarMateriaPorId (Integer id)throws Exception{
        try {

            Optional<Subject>subjectQueEstoyBuscando= this.repository.findById(id);
            if (subjectQueEstoyBuscando.isPresent()){
                return subjectQueEstoyBuscando.get();
            }else {
                throw new Exception(MessagesApi.ERROR_SUBJECT_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Subject modificarsubject(Integer id, Subject datosNuevosSubject)throws Exception {
        try {
            Optional<Subject> subjectQueEstoyBuscandoParaEditar = this.repository.findById(id);
            if (subjectQueEstoyBuscandoParaEditar.isPresent()) {
                //Modifico esa materia
                subjectQueEstoyBuscandoParaEditar.get().setName(datosNuevosSubject.getName());
                //guardo las modificaciones en BD
                return this.repository.save(subjectQueEstoyBuscandoParaEditar.get());
            } else {
                throw new Exception(MessagesApi.ERROR_SUBJECT_NO_ENCONTRADO.getMenssages());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }
    //Metodo para eliminar
}
