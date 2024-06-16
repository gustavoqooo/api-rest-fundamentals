package pe.edu.cibertec.api_rest_fundamentals.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_fundamentals.model.GeneralRequest;
import pe.edu.cibertec.api_rest_fundamentals.model.GeneralResponse;
import pe.edu.cibertec.api_rest_fundamentals.service.PersonaService;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/otrasope")
public class OtrasOperacionesController {

    private PersonaService personaService;

    @PostMapping("/persona/{nombre}")
    public ResponseEntity<GeneralResponse> ejemploPost(
            @PathVariable String nombre,
            @RequestBody GeneralRequest generalRequest){
        String mensaje = "Persona no encontrada";
        if (personaService.buscarPersona(nombre)){
            mensaje = "Persona encontrada";
        }
        GeneralResponse response =  GeneralResponse.builder().mensaje(mensaje).build();
        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }

}
