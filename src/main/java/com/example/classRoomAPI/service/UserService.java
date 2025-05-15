package com.example.classRoomAPI.service;

import com.example.classRoomAPI.helpers.MessagesApi;
import com.example.classRoomAPI.models.Tuition;
import com.example.classRoomAPI.models.User;
import com.example.classRoomAPI.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository repository;

    //Metodo para guardar
    public User saveUser(User dateUser)throws Exception{
        try {

            return this.repository.save(dateUser);

        }catch (Exception Error){
            throw new Exception();
        }
    }

    //Metodo para buscarTodos
    public List<User>ListUsers()throws Exception{
        try {

            return  this.repository.findAll();

        }catch (Exception Error){
            throw new Exception();
        }
    }


    //Metodo para buscarUnoPorId
    public User buscarUsuarioPorId(Integer id)throws Exception{
        try {
            Optional<User> userQueEstoyBuscando= this.repository.findById(id);
            if (userQueEstoyBuscando.isPresent()){
                return userQueEstoyBuscando.get();
            }else {
                throw new Exception(MessagesApi.ERROR_USER_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public User modificarCalificacion(Integer id, User datosNuevosUser)throws Exception{
        try {
            Optional<User> userQueEstoyBuscandoParaEditar= this.repository.findById(id);
            if (userQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico esa calificacion
                userQueEstoyBuscandoParaEditar.get().setUserType(datosNuevosUser.getUserType());
                userQueEstoyBuscandoParaEditar.get().setPhone(datosNuevosUser.getPhone());
                userQueEstoyBuscandoParaEditar.get().setPassword(datosNuevosUser.getPassword());
                userQueEstoyBuscandoParaEditar.get().setEmail(datosNuevosUser.getEmail());
                userQueEstoyBuscandoParaEditar.get().setName(datosNuevosUser.getName());
                //guardo las modificaciones en BD
                return this.repository.save(userQueEstoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MessagesApi.ERROR_USER_NO_ENCONTRADO.getMenssages());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
}
