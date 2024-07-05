package marinalucentini.gestioneEventi.Prenotazione.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PrenotazioneDto(
        @NotEmpty (message = "Il titolo è un campo obbligatorio")
        String evento,
        @NotEmpty (message = "La descrizione è un campo obbligatorio")
        String utente

) {
}
