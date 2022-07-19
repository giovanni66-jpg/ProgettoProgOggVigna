package gestionale.entities;

import java.util.Date;
import java.util.List;

abstract class Attivita {
    private int codice;
    private List<Cliente> clienti;
    private PacchettoAttivita pacchetto;
    private Boolean scontoPromozionale;
    private Date data;
    
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
    public Date getData() {
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
    public void setData(Date data) {
        this.data = data;
    }
}
