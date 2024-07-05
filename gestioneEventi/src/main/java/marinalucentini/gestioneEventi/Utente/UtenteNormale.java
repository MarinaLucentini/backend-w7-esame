package marinalucentini.gestioneEventi.Utente;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@DiscriminatorValue("utente-normale")
@Getter
@Setter
public class UtenteNormale extends Utente{

    public UtenteNormale(String nome, String cognome, String email, String password) {
        super(nome, cognome, email, password);
    }
}
