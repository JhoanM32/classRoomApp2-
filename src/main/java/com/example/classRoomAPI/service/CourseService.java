package com.example.classRoomAPI.service;

import com.example.classRoomAPI.helpers.MessagesApi;
import com.example.classRoomAPI.models.Course;
import com.example.classRoomAPI.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Course>ListCourses()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }


    //Metodo para buscarUnoPorId
    public Course buscarCursoPorId(Integer id)throws Exception{
        try {
            Optional<Course>courseQueEstoyBuscando=this.repository.findById(id);
            if (courseQueEstoyBuscando.isPresent()){
                return courseQueEstoyBuscando.get();

            }else {
                throw new Exception(MessagesApi.ERROR_COURSE_NO_ENCONTRADO.getMenssages());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //Metodo para modificar
    public Course modificarCurso(Integer id, Course datosNuevosCourse)throws Exception{
        try {
            Optional<Course>courseQueEstoyBuscandoParaEditar=this.repository.findById(id);
            if (courseQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese Curso
                courseQueEstoyBuscandoParaEditar.get().setName(datosNuevosCourse.getName());
                //guardo las modificaciones en BD
                return this.repository.save(courseQueEstoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MessagesApi.ERROR_COURSE_NO_ENCONTRADO.getMenssages());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //Metodo para eliminar


}
