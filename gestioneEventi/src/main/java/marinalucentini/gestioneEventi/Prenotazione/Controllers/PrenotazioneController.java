package marinalucentini.gestioneEventi.Prenotazione.Controllers;

import marinalucentini.gestioneEventi.Eventi.Payload.EventoDto;
import marinalucentini.gestioneEventi.Eventi.Payload.EventoResponseDto;
import marinalucentini.gestioneEventi.Eventi.Service.EventoService;
import marinalucentini.gestioneEventi.Exception.BadRequestException;
import marinalucentini.gestioneEventi.Prenotazione.Payload.PrenotazioneDto;
import marinalucentini.gestioneEventi.Prenotazione.Payload.PrenotazioneResponseDto;
import marinalucentini.gestioneEventi.Prenotazione.Service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
    @Autowired
    PrenotazioneService prenotazioneService;
    @PostMapping
    @PreAuthorize("hasAuthority('UTENTE')")
    public PrenotazioneResponseDto creazioneEvento(@RequestBody @Validated PrenotazioneDto prenotazioneDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors());
        }
        return new PrenotazioneResponseDto(prenotazioneService.save(prenotazioneDto).getId());
    }
}
