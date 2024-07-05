package marinalucentini.gestioneEventi.Utente.Services;

import marinalucentini.gestioneEventi.Exception.NotFoundExp;
import marinalucentini.gestioneEventi.Utente.Payload.UtenteDto;
import marinalucentini.gestioneEventi.Utente.Repository.UtenteRepository;
import marinalucentini.gestioneEventi.Utente.Ruolo;
import marinalucentini.gestioneEventi.Utente.Utente;
import marinalucentini.gestioneEventi.Exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
   private UtenteRepository utenteRepository;
    @Autowired
    private PasswordEncoder bcrypt;
public Utente findById(UUID id){
return utenteRepository.findById(id).orElseThrow(()-> new NotFoundExp(id));
}
public Utente findByEmail(String email){
    return utenteRepository.findByEmail(email).orElseThrow(()-> new NotFoundExp("Utente non trovato"));
}
    public Ruolo ruolo (UtenteDto utenteDto){
        try {
            return Ruolo.valueOf(utenteDto.ruolo().toUpperCase());
        }catch (IllegalArgumentException ex){
            throw new BadRequestException("Il ruolo deve essere UTENTE o ORGANIZZATORE, riprova!");
        }
    }
public Utente save(UtenteDto utenteDto){
utenteRepository.findByEmail(utenteDto.email()).ifPresent(
utente -> {
    throw new BadRequestException("L'email " + utenteDto.email() + " è già in uso");
}
);

Utente utente = new Utente(utenteDto.nome(), utenteDto.cognome(), utenteDto.email(), bcrypt.encode(utenteDto.password()), ruolo(utenteDto));
return utenteRepository.save(utente);
}

}
