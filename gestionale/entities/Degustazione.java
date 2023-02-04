package gestionale.entities;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Degustazione extends Attivita {

    private Somelier somelier;
    private List<String> listaVini;

    public Degustazione(){}

    public Somelier getSomelier() {
        return somelier;
    }
    public void setSomelier(Somelier somelier) {
        this.somelier = somelier;
    }
    public List<String> getListaVini() {
        return listaVini;
    }
    public void setListaVini(List<String> listaVini) {
        this.listaVini = listaVini;
    }

    @Override
    public JSONObject toJsonObjFinale() {
        JSONObject degustazioneJson = toJsonObj();
        degustazioneJson.put("Dipendente", somelier);
        degustazioneJson.put("tipoAttivita", "Degustazione");
        JSONArray viniArray = new JSONArray();
        for (String vino : listaVini) {
            JSONObject vinoJson = new JSONObject();
            vinoJson.put("NomeVino", vino);
            viniArray.put(vinoJson);
        }
        degustazioneJson.put("Clienti", viniArray.toString());
        return degustazioneJson;
    }


}
