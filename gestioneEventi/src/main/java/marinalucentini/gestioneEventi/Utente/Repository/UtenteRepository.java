package marinalucentini.gestioneEventi.Utente.Repository;

import marinalucentini.gestioneEventi.Utente.Utente;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository {
    Optional<Utente> findByEmail (String email);
}
