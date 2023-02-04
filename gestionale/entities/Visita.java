package gestionale.entities;

import org.json.JSONObject;

public class Visita extends Attivita{

    private Guida guida;
    private String durata;

    public Visita(){}

    public Guida getGuida() {
        return guida;
    }
    public void setGuida(Guida guida) {
        this.guida = guida;
    }
    public String getDurata() {
        return durata;
    }
    public void setDurata(String durata) {
        this.durata = durata;
    }

    @Override
    public JSONObject toJsonObjFinale() {
        JSONObject visitaJson = toJsonObj();
        visitaJson.put("tipoAttivita", "Visita");
        visitaJson.put("Dipendente", guida);
        visitaJson.put("Durata", durata);
        return visitaJson;
    }
}
