package marinalucentini.gestioneEventi.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorDto(String message, LocalDateTime time) {
}
