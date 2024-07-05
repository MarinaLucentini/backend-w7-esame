package marinalucentini.gestioneEventi.Utente.Payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UtenteLoginDto(
        @Email(message = "Email non valida")
        String email,
        @NotEmpty (message = "Il campo password è obbligatorio")
        String password
) {
}
