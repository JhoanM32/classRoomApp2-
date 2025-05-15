package Controller;


import com.example.classRoomAPI.models.Subject;
import com.example.classRoomAPI.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materias")
public class SubjectController {
    @Autowired
    SubjectService service;

    //guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Subject datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveSubject(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    //buscartodos

    //buscarPorid


    //modificar


}
