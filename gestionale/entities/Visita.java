package gestionale.entities;

public class Visita extends Attivita {

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
}
