package marinalucentini.gestioneEventi.Utente.Services;

import marinalucentini.gestioneEventi.Exception.NotFoundExp;
import marinalucentini.gestioneEventi.Utente.Repository.UtenteRepository;
import marinalucentini.gestioneEventi.Utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
   private UtenteRepository utenteRepository;
public Utente findById(UUID id){
return utenteRepository.findById(id).orElseThrow(()-> new NotFoundExp(id));
}
}
