package pe.edu.cibertec.api_rest_fundamentals.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_fundamentals.service.IOperacionesService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OperacionesController {

    private IOperacionesService iOperacionesService;
    //Prueba en Postman = localhost:8055/api/v1/esprimo/11
    @GetMapping("/esprimo/{numero}")
    public boolean validarNumeroPrimo(@PathVariable int numero){
        return iOperacionesService.validarNumeroEsPrimo(numero);
    }
    //Prueba en Postman = localhost:8055/api/v1/exponente/2/4
    @GetMapping("/exponente/{num}/{expo}")
    public double elevarNumeroAExponente(@PathVariable int num,
                                         @PathVariable int expo){
        return iOperacionesService.elevarNumeroAlExponente(num, expo);
    }

    //Prueba en Postman = localhost:8055/api/v1/primo?numero=11
    @GetMapping("/primo")
    public boolean validarPrimo(@RequestParam int numero,
                                @RequestParam(required = false) boolean filtro){
        return iOperacionesService.validarNumeroEsPrimo(numero);
    }

    //Prueba en Postman = localhost:8055/api/v1/elevarexponente?num=11&expo=2
    @GetMapping("/elevarexponente")
    public double elevarNumeroAExponenteQuery(@RequestParam int num,
                                         @RequestParam(defaultValue = "2") int expo){
        return iOperacionesService.elevarNumeroAlExponente(num, expo);
    }

    //Prueba en Postman = localhost:8055/api/v1/datos/11?nombres=Luis&nombres=Angel
    @GetMapping("/datos/{num}")
    public String listaNombres(@PathVariable int num,
            @RequestParam List<String> nombres){
        return "Nombres: "+ String.join(", ", nombres);
    }

}
