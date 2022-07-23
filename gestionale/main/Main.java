package gestionale.main;

import java.util.ArrayList;
import java.util.List;

import gestionale.controller.GestioneFile;
import gestionale.entities.Cliente;
import gestionale.entities.Guida;
import gestionale.entities.Utente;

public class Main {
    public static void main(String[] args){
        List<Utente> utenti = new ArrayList<>();
        Guida guida = new Guida();
        guida.setUsername("Piero");
        guida.setMail("mailPiero");
        guida.setPassword("passwordPiero");
        Cliente cliente = new Cliente();
        cliente.setUsername("Gigio");
        cliente.setMail("mailGigio");
        cliente.setPassword("passwordGigio");
        utenti.add(guida);
        utenti.add(cliente);
        GestioneFile.getInstance().scriviFileUtenti(utenti);
        GestioneFile.getInstance().leggiFileUtenti();
    }
}