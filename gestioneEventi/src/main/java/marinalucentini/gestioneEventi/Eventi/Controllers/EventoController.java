package marinalucentini.gestioneEventi.Eventi.Controllers;

import marinalucentini.gestioneEventi.Eventi.Evento;
import marinalucentini.gestioneEventi.Eventi.Payload.EventoDto;
import marinalucentini.gestioneEventi.Eventi.Payload.EventoResponseDto;
import marinalucentini.gestioneEventi.Eventi.Service.EventoService;
import marinalucentini.gestioneEventi.Exception.BadRequestException;
import marinalucentini.gestioneEventi.Utente.Payload.UtenteDto;
import marinalucentini.gestioneEventi.Utente.Payload.UtenteRensponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    EventoService eventoService;
    @PostMapping
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public EventoResponseDto creazioneEvento(@RequestBody @Validated EventoDto eventoDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors());
        }
        return new EventoResponseDto(eventoService.save(eventoDto).getId());
    }
}
