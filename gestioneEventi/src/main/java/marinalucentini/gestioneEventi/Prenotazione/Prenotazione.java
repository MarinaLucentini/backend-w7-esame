package marinalucentini.gestioneEventi.Prenotazione;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marinalucentini.gestioneEventi.Eventi.Evento;
import marinalucentini.gestioneEventi.Utente.Utente;

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
    private Utente utente;

    public Prenotazione(Evento evento, Utente utente) {
        this.evento = evento;
        this.utente = utente;
    }
}
