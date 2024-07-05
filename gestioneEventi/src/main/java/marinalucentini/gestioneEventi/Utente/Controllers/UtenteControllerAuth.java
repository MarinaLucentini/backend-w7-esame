package marinalucentini.gestioneEventi.Utente.Controllers;

import marinalucentini.gestioneEventi.Exception.BadRequestException;
import marinalucentini.gestioneEventi.Utente.Payload.UtenteDto;
import marinalucentini.gestioneEventi.Utente.Payload.UtenteRensponseDto;
import marinalucentini.gestioneEventi.Utente.Services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class
UtenteControllerAuth {
    @Autowired
    UtenteService utenteService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UtenteRensponseDto employeeResponseDto  (@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors());
        }
        return new UtenteRensponseDto(utenteService.save(utenteDto).getId());
    }
}
