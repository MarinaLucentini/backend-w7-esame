package marinalucentini.gestioneEventi.Prenotazione.Service;

import marinalucentini.gestioneEventi.Eventi.Evento;
import marinalucentini.gestioneEventi.Eventi.Payload.EventoDto;
import marinalucentini.gestioneEventi.Eventi.Repository.EventoRepository;
import marinalucentini.gestioneEventi.Eventi.Service.EventoService;
import marinalucentini.gestioneEventi.Prenotazione.Payload.PrenotazioneDto;
import marinalucentini.gestioneEventi.Prenotazione.Prenotazione;
import marinalucentini.gestioneEventi.Prenotazione.Repository.PrenotazioneRepository;
import marinalucentini.gestioneEventi.Utente.Services.UtenteService;
import marinalucentini.gestioneEventi.Utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    UtenteService utenteService;
    @Autowired
    EventoService eventoService;
    public Prenotazione save(PrenotazioneDto prenotazioneDto, Utente utente){
Evento evento = eventoService.findById(UUID.fromString(prenotazioneDto.evento()));
        Prenotazione prenotazione = new Prenotazione(evento, utente);
        return prenotazioneRepository.save(prenotazione);
    }
}
