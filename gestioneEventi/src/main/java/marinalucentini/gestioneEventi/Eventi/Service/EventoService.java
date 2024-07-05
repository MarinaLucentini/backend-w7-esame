package marinalucentini.gestioneEventi.Eventi.Service;

import marinalucentini.gestioneEventi.Eventi.Evento;
import marinalucentini.gestioneEventi.Eventi.Payload.EventoDto;
import marinalucentini.gestioneEventi.Eventi.Repository.EventoRepository;
import marinalucentini.gestioneEventi.Exception.BadRequestException;
import marinalucentini.gestioneEventi.Exception.NotFoundExp;
import marinalucentini.gestioneEventi.Utente.Payload.UtenteDto;
import marinalucentini.gestioneEventi.Utente.Services.UtenteService;
import marinalucentini.gestioneEventi.Utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    UtenteService utenteService;
    public Evento save(EventoDto eventoDto, Utente utente){

        Evento evento = new Evento(eventoDto.titolo(), eventoDto.descrizione(), eventoDto.data(), eventoDto.luogo(), eventoDto.posti_disponibili(), utenteService.findById(utente.getId()));
        return eventoRepository.save(evento);
    }
    public Evento findById(UUID id){
        return eventoRepository.findById(id).orElseThrow(()-> new NotFoundExp(id));
    }
}
