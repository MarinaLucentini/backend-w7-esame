package marinalucentini.gestioneEventi.Exception;

import java.util.UUID;

public class NotFoundExp extends RuntimeException{
    public NotFoundExp (UUID id){
super("Record con id " + id + "non trovato!");
    }
    public NotFoundExp (String message){
        super(message);
    }
}
