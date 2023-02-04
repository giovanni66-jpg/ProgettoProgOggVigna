package gestionale.entities;

import org.json.JSONObject;

public class Somelier extends Utente{

    public Somelier(){}

    @Override
    public JSONObject toJsonObjFinale() {
        JSONObject utenteJson = toJsonObj();
        utenteJson.put("tipoUtente", "Somelier");
        return utenteJson;
    }
    
}
