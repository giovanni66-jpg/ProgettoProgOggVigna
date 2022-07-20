package gestionale.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.catalog.Catalog;

import gestionale.entities.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestioneFile {
    
    private static volatile GestioneFile instance = null;

    private String PATH_UTENTI = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/Utenti.json";
    private String PATH_ATTIVITA = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/Attivita.json";
    private String PATH_PRENOTAZIONI = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/Prenotazioni.json";
    private String PATH_UTENTI_ATTIVITA = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/UtentiAttivita.json";
    private String PATH_TURNI_LAVORATIVI = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/TurniLavorativi.json";

    private GestioneFile(){}

    public static synchronized GestioneFile getInstance(){
        if(instance == null){
            synchronized(GestioneFile.class){
                if(instance==null){
                    instance = new GestioneFile();
                }
            }
        }
        return instance;
    }

    public void creaFileUtenti(){
        try (FileWriter file = new FileWriter(PATH_UTENTI)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFileAttivita(){
        try (FileWriter file = new FileWriter(PATH_ATTIVITA)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFilePrenotazioni(){
        try (FileWriter file = new FileWriter(PATH_PRENOTAZIONI)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFileUtentiAttivita(){
        try (FileWriter file = new FileWriter(PATH_UTENTI_ATTIVITA)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFileTurniLavorativi(){
        try (FileWriter file = new FileWriter(PATH_TURNI_LAVORATIVI)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Utente> leggiFileUtenti(){
        List<Utente> utenti = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader(PATH_UTENTI));
            for (int i = 0; i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                switch(object.getString("tipoUtente")){
                    case("Cliente") : {
                        Cliente cliente = new Cliente();
                        cliente.parseJson(object);
                        utenti.add(cliente);
                    }
                    break;
                    case("Guida") : {
                        Guida guida = new Guida();
                        guida.parseJson(object);
                        utenti.add(guida);
                    }
                    break;
                    case("Somelier") : {
                        Somelier somelier = new Somelier();
                        somelier.parseJson(object);
                        utenti.add(somelier);
                    }
                    break;
                }
            }
        } catch (IOException io) {
            creaFileUtenti();
        } catch(ParseException e){
            e.printStackTrace();
        }
        return utenti;
    }

    public void leggiFileAttivita(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader(PATH_ATTIVITA));
            for (Object object : array) {
                System.out.println("l'oggetto in questione è:... ");
                System.out.println(object);
            }
        } catch (IOException io) {
            creaFileAttivita();
        } catch(ParseException e){
            e.printStackTrace();
        }
    }

    public void leggiFilePrenotazioni(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader(PATH_PRENOTAZIONI));
            for (Object object : array) {
                System.out.println("l'oggetto in questione è:... ");
                System.out.println(object);
            }
        } catch (IOException io) {
            creaFilePrenotazioni();
        } catch(ParseException e){
            e.printStackTrace();
        }
    }

    public void leggiFileUtentiAttivita(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader(PATH_UTENTI_ATTIVITA));
            for (Object object : array) {
                System.out.println("l'oggetto in questione è:... ");
                System.out.println(object);
            }
        } catch (IOException io) {
            creaFileUtentiAttivita();
        } catch(ParseException e){
            e.printStackTrace();
        }
    }

    public void leggiFileTurniLavorativi(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader(PATH_TURNI_LAVORATIVI));
        } catch (IOException io) {
            creaFileTurniLavorativi();
        } catch(ParseException e){
            e.printStackTrace();
        }
    }

    public void scriviFileUtenti(List<Utente> utenti){
        JSONArray utentiListJSON = new JSONArray();
        for (Utente utente : utenti) {
            utentiListJSON.put(utente.toJsonObjFinale());
        }
        String text = utentiListJSON.toString();

        try (FileWriter file = new FileWriter(PATH_UTENTI)) {
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
