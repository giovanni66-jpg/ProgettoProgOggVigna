package gestionale.entities;

import org.json.JSONObject;

public class Guida extends Utente{

    public Guida(){}

    @Override
    public JSONObject toJsonObjFinale() {
        JSONObject utenteJson = toJsonObj();
        utenteJson.put("tipoUtente", "Guida");
        return utenteJson;
    }
    
}
