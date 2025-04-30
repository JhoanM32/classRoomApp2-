package com.example.classRoomAPI.service;

import com.example.classRoomAPI.models.Teacher;
import com.example.classRoomAPI.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    ITeacherRepository repository;

    //Metodo para guardar
    public Teacher saveTeacher(Teacher dateTeacher)throws Exception{
        try {

            return this.repository.save(dateTeacher);

        }catch (Exception Error){
            throw new Exception();
        }
    }
    //Metodo para buscarTodos
    public List<Teacher>ListTeachers()throws Exception{
        try{

            return this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }


    //Metodo para buscarUnoPorId


    //Metodo para modificar


    //Metodo para eliminar
}
