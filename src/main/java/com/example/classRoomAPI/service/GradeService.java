package com.example.classRoomAPI.service;

import com.example.classRoomAPI.helpers.MessagesApi;
import com.example.classRoomAPI.models.Grade;
import com.example.classRoomAPI.repositories.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    IGradeRepository repository;


    //Metodo para guardar
    public Grade saveGrade(Grade dateGrade)throws Exception{
        try {

            return this.repository.save(dateGrade);

        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo para buscarTodos
    public List<Grade>ListGrades()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }


    //Metodo para buscarUnoPorId
    public Grade buscarCalificacionPorId(Integer id)throws Exception{
        try {
            Optional<Grade>gradeQueEstoyBuscando= this.repository.findById(id);
            if (gradeQueEstoyBuscando.isPresent()){
                return gradeQueEstoyBuscando.get();
            }else {
                throw new Exception(MessagesApi.ERROR_GRADE_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Grade modificarCalificacion(Integer id, Grade datosNuevosGrade)throws Exception{
        try {
            Optional<Grade>gradeQueEstoyBuscandoParaEditar= this.repository.findById(id);
            if (gradeQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico esa calificacion
                gradeQueEstoyBuscandoParaEditar.get().setGrade(datosNuevosGrade.getGrade());
                //guardo las modificaciones en BD
                return this.repository.save(gradeQueEstoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MessagesApi.ERROR_GRADE_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar


}
