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

import org.json.simple.*;
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

    public void leggiFileUtenti(){
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(new FileReader(PATH_UTENTI));
            System.out.println(object);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void scriviFileUtenti(List<Utente> utenti){
        JSONArray utentiListJSON = new JSONArray();
        for (Utente utente : utenti) {
            utentiListJSON.add(utente.toJsonObj());
        }
        String text = utentiListJSON.toJSONString();

        try (FileWriter file = new FileWriter(PATH_UTENTI)) {
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
