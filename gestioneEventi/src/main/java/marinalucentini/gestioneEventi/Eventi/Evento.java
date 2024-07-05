package marinalucentini.gestioneEventi.Eventi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marinalucentini.gestioneEventi.Utente.Utente;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int posti_disponibili;
    @ManyToOne
    @JoinColumn (name = "id_organizzatore", nullable = false)
    private Utente  utente;


    public Evento(String titolo, String descrizione, LocalDate data, String luogo, int posti_disponibili, Utente utente) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.luogo = luogo;
        this.posti_disponibili = posti_disponibili;
        this.utente = utente;
    }
}
