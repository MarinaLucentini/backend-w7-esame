package marinalucentini.gestioneEventi.Eventi.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoDto(
        @NotEmpty (message = "Il titolo è un campo obbligatorio")
        String titolo,
        @NotEmpty (message = "La descrizione è un campo obbligatorio")
        String descrizione,
        @NotNull (message = "La data è un campo obbligatorio")
        LocalDate data,
        @NotEmpty (message = "Il luogo è un campo obbligatorio")
        String luogo,
        @NotNull (message = "Il numero dei posti è un campo obbligatorio")
        int posti_disponibili
) {
}
