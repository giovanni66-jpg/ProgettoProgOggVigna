package gestionale.entities;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Attivita {
    protected int codice;
    protected List<Cliente> clienti;
    protected PacchettoAttivita pacchetto;
    protected Boolean scontoPromozionale;
    protected String data;
    
    public int getCodice() {
        return codice;
    }
    public List<Cliente> getClienti() {
        return clienti;
    }
    public PacchettoAttivita getPacchetto() {
        return pacchetto;
    }
    public Boolean getScontoPromozionale() {
        return scontoPromozionale;
    }
    public String getData() {
        return data;
    }
    public void setCodice(int codice) {
        this.codice = codice;
    }
    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }
    public void setPacchetto(PacchettoAttivita pacchetto) {
        this.pacchetto = pacchetto;
    }
    public void setScontoPromozionale(Boolean scontoPromozionale) {
        this.scontoPromozionale = scontoPromozionale;
    }
    public void setData(String data) {
        this.data = data;
    }

    public JSONObject toJsonObj() {
        JSONObject attivitaJson = new JSONObject();
        attivitaJson.put("Codice", codice);
        attivitaJson.put("Data", data);
        attivitaJson.put("Pacchetto", pacchetto);
        attivitaJson.put("Sconto", scontoPromozionale);
        JSONArray utentiArray = new JSONArray();
        for (Cliente cliente : clienti) {
            JSONObject clienteJson = new JSONObject();
            clienteJson.put("Username", cliente.getUsername());
            utentiArray.put(clienteJson);
        }
        attivitaJson.put("Clienti", utentiArray.toString());
        return attivitaJson;
    }

    public abstract JSONObject toJsonObjFinale();

    public void parseJson(JSONObject object, List<Cliente> tuttiClienti){
        codice = Integer.parseInt(object.getString("Codice"));
        data = object.getString("Data");
        String appoggioPacchetto = object.getString("Pacchetto");
        switch(appoggioPacchetto){
            case "Base" : pacchetto = PacchettoAttivita.Base;
            break;
            case "Medio" : pacchetto = PacchettoAttivita.Medio;
            break;
            case "Completo" : pacchetto = PacchettoAttivita.Completo;
            break;
        }
        scontoPromozionale = object.getBoolean("Sconto");
        clienti = new ArrayList<>();
        JSONArray clientiArray = object.getJSONArray("Clienti");
        for (int k = 0; k < clientiArray.length(); k++) {
            JSONObject clienteJsonObject = clientiArray.getJSONObject(k);
            String clienteUsername = clienteJsonObject.getString("Username");
            for (Cliente cliente : tuttiClienti) {
                if(clienteUsername.equals(cliente.getUsername())){
                    if(!clienti.contains(cliente)){
                        clienti.add(cliente);
                    }
                }
            }
        }
    }
}
