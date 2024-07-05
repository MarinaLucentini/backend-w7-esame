package marinalucentini.gestioneEventi.Prenotazione;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marinalucentini.gestioneEventi.Eventi.Evento;
import marinalucentini.gestioneEventi.Utente.UtenteNormale;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue
    private UUID id;
@ManyToOne
    @JoinColumn (name = "id_evento")
    private Evento evento;
@ManyToOne
    @JoinColumn(name = "id_utente")
    private UtenteNormale utenteNormale;

    public Prenotazione(Evento evento, UtenteNormale utenteNormale) {
        this.evento = evento;
        this.utenteNormale = utenteNormale;
    }
}
