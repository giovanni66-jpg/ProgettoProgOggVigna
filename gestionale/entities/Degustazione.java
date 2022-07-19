package gestionale.entities;

import java.util.List;

public class Degustazione extends Attivita{

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
}
