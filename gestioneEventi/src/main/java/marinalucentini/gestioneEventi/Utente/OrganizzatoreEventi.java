package marinalucentini.gestioneEventi.Utente;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("organizzatore-eventi")
public class OrganizzatoreEventi extends Utente{
    public OrganizzatoreEventi(String nome, String cognome, String email, String password) {
        super(nome, cognome, email, password);
    }
}
