package Controller;


import com.example.classRoomAPI.models.Tuition;
import com.example.classRoomAPI.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calificaciones")
public class GradeController {

    @Autowired
    TuitionService service;

    //guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Tuition datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveTuition(datosQueEnviaElCliente));

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
