package gestionale.entities;

import org.json.JSONObject;

public class Cliente extends Utente {
    
    public Cliente(){
    }

    @Override
    public JSONObject toJsonObjFinale() {
        JSONObject utenteJson = toJsonObj();
        utenteJson.put("tipoUtente", "Cliente");
        return utenteJson;
    }
}
