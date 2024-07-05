package marinalucentini.gestioneEventi.Utente.Services;

import marinalucentini.gestioneEventi.Exception.UnauthorizedException;
import marinalucentini.gestioneEventi.Security.JWTTool;
import marinalucentini.gestioneEventi.Utente.Payload.UtenteLoginDto;
import marinalucentini.gestioneEventi.Utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteAuthService {
    @Autowired
    UtenteService utenteService;
@Autowired
    JWTTool jwtTool;
@Autowired
    PasswordEncoder bcrypt;
    public String authenticateUserAndGenerateToken(UtenteLoginDto payload){

        Utente utente = utenteService.findByEmail(payload.email());

        if(bcrypt.matches(payload.password(), utente.getPassword())){

            return jwtTool.createToken(utente);
        } else {

            throw new UnauthorizedException("Credenziali non corrette!");
        }
    }
}
