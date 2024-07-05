package marinalucentini.gestioneEventi.Utente.Payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UtenteDto(
        @NotEmpty(message = "Il campo nome è obbligatorio")
                @Size(min = 4, max = 40, message = "Il nome deve avere un numero di caratteri tra 4 e 40")
        String nome,
        @NotEmpty(message = "Il campo cognome è obbligatorio")
        @Size(min = 4, max = 40, message = "Il cognome deve avere un numero di caratteri tra 4 e 40")
        String cognome,
        @Email(message = "Email non valida, riprova")
        String email,
        @NotEmpty(message = "Il campo password è obbligatorio")

        String password,
        @NotEmpty(message = "Il campo ruolo è obbligatorio")
        String ruolo
) {
}
