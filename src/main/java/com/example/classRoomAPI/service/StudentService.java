package com.example.classRoomAPI.service;
import com.example.classRoomAPI.helpers.MessagesApi;
import com.example.classRoomAPI.models.Student;
import com.example.classRoomAPI.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepository repository;

    //Metodo para guardar
    public Student saveStudent(Student dateStudent)throws Exception{
        try{

            return this.repository.save(dateStudent);

        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo para buscarTodos
    public List<Student>ListStudents()throws Exception{
        try {

            return this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }

    //Metodo para buscarUnoPorId
    public Student busacarEstudientePorId(Integer id)throws Exception{
        try {

            Optional<Student>studentQueEstoyBuscando= this.repository.findById(id);
            if (studentQueEstoyBuscando.isPresent()){
                return studentQueEstoyBuscando.get();
            }else {
                throw new Exception(MessagesApi.ERROR_STUDENT_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Student modificarStudent(Integer id, Student datosNuevosStudent)throws Exception{
        try {
            Optional<Student>studentQueEstoyBuscandoParaEditar= this.repository.findById(id);
            if (studentQueEstoyBuscandoParaEditar.isPresent()) {
                //Modifico ese Studiante
                studentQueEstoyBuscandoParaEditar.get().setGrade(datosNuevosStudent.getGrade());
                studentQueEstoyBuscandoParaEditar.get().setBirthdate(datosNuevosStudent.getBirthdate());
                studentQueEstoyBuscandoParaEditar.get().setAddress(datosNuevosStudent.getAddress());
                //guardo las modificaciones en BD
                return this.repository.save(studentQueEstoyBuscandoParaEditar.get());

            }else {
                throw new Exception(MessagesApi.ERROR_STUDENT_NO_ENCONTRADO.getMenssages());

            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar


}
