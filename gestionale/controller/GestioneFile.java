package gestionale.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import gestionale.entities.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class GestioneFile {

    private static volatile GestioneFile instance = null;

    private String PATH_UTENTI = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/fileApp/Utenti.json";
    private String PATH_ATTIVITA = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/fileApp/Attivita.json";
    private String PATH_PRENOTAZIONI = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/fileApp/Prenotazioni.json";
    private String PATH_UTENTI_ATTIVITA = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/fileApp/UtentiAttivita.json";
    private String PATH_TURNI_LAVORATIVI = "/Users/pieromarraffa/Documents/GitHub/ProgettoProgOggVigna/fileApp/TurniLavorativi.json";

    private GestioneFile() {
    }

    public static synchronized GestioneFile getInstance() {
        if (instance == null) {
            synchronized (GestioneFile.class) {
                if (instance == null) {
                    instance = new GestioneFile();
                }
            }
        }
        return instance;
    }

    public void creaFileUtenti() {
        try (FileWriter file = new FileWriter(PATH_UTENTI)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFileAttivita() {
        try (FileWriter file = new FileWriter(PATH_ATTIVITA)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFilePrenotazioni() {
        try (FileWriter file = new FileWriter(PATH_PRENOTAZIONI)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFileUtentiAttivita() {
        try (FileWriter file = new FileWriter(PATH_UTENTI_ATTIVITA)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creaFileTurniLavorativi() {
        try (FileWriter file = new FileWriter(PATH_TURNI_LAVORATIVI)) {
            file.write("");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Utente> leggiFileUtenti() {
        List<Utente> utenti = new ArrayList<>();
        try {
            File file = new File(PATH_UTENTI);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                JSONArray array = new JSONArray(scanner.nextLine());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    switch (object.getString("tipoUtente")) {
                        case ("Cliente"): {
                            Cliente cliente = new Cliente();
                            cliente.parseJson(object);
                            utenti.add(cliente);
                        }
                            break;
                        case ("Guida"): {
                            Guida guida = new Guida();
                            guida.parseJson(object);
                            utenti.add(guida);
                        }
                            break;
                        case ("Somelier"): {
                            Somelier somelier = new Somelier();
                            somelier.parseJson(object);
                            utenti.add(somelier);
                        }
                            break;
                    }
                }
            }
            scanner.close();
        } catch (IOException io) {
            creaFileUtenti();
        }
        return utenti;
    }

    public List<Attivita> leggiFileAttivita(List<Cliente> clienti) {
        List<Attivita> attivita = new ArrayList<>();
        try {
            File file = new File(PATH_ATTIVITA);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                JSONArray array = new JSONArray(scanner.nextLine());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    switch (object.getString("tipoAttivita")) {
                        case ("Degustazione"): {
                            Degustazione degustazione = new Degustazione();
                            degustazione.parseJson(object, clienti);
                            attivita.add(degustazione);
                        }
                            break;
                        case ("Visita"): {
                            Visita visita = new Visita();
                            visita.parseJson(object, clienti);
                            attivita.add(visita);
                        }
                            break;
                    }
                }
            }
            scanner.close();
        } catch (IOException io) {
            creaFileAttivita();
        }
        return attivita;
    }

    public HashMap<Attivita, Cliente> leggiFilePrenotazioni(List<Cliente> clienti, List<Attivita> attivita) {
        HashMap<Attivita, Cliente> prenotazioni = new HashMap<>();
        try {
            File file = new File(PATH_PRENOTAZIONI);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                JSONArray array = new JSONArray(scanner.nextLine());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    for (Cliente cliente : clienti) {
                        if (cliente.getUsername().equals(object.getString("Username"))) {
                            for (Attivita attivitina : attivita) {
                                if (attivitina.getCodice() == Integer.parseInt(object.getString("CodiceAttivita"))) {
                                    prenotazioni.put(attivitina, cliente);
                                }
                            }
                        }
                    }
                }
            }
            scanner.close();
        } catch (IOException io) {
            creaFilePrenotazioni();
        }
        return prenotazioni;
    }

    public HashMap<Attivita, Cliente> leggiFileUtentiAttivita(List<Cliente> clienti, List<Attivita> attivita) {
        HashMap<Attivita, Cliente> attivitaPassate = new HashMap<>();
        try {
            File file = new File(PATH_UTENTI_ATTIVITA);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                JSONArray array = new JSONArray(scanner.nextLine());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    for (Cliente cliente : clienti) {
                        if (cliente.getUsername().equals(object.getString("Username"))) {
                            for (Attivita attivitina : attivita) {
                                if (attivitina.getCodice() == Integer.parseInt(object.getString("CodiceAttivita"))) {
                                    attivitaPassate.put(attivitina, cliente);
                                }
                            }
                        }
                    }
                }
            }
            scanner.close();
        } catch (IOException io) {
            creaFileUtentiAttivita();
        }
        return attivitaPassate;
    }

    public HashMap<Attivita, Utente> leggiFileTurniLavorativi(List<Utente> utenti, List<Attivita> attivita) {
        HashMap<Attivita, Utente> turni = new HashMap<>();
        try {
            File file = new File(PATH_TURNI_LAVORATIVI);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                JSONArray array = new JSONArray(scanner.nextLine());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    for (Utente utente : utenti) {
                        if (utente.getUsername().equals(object.getString("Username"))) {
                            for (Attivita attivitina : attivita) {
                                if (attivitina.getCodice() == Integer.parseInt(object.getString("CodiceAttivita"))) {
                                    turni.put(attivitina, utente);
                                }
                            }
                        }
                    }
                }
            }
            scanner.close();
        } catch (IOException io) {
            creaFileTurniLavorativi();
        }
        return turni;
    }

    public void scriviFileUtenti(List<Utente> utenti) {
        JSONArray utentiListJSON = new JSONArray();
        for (Utente utente : utenti) {
            utentiListJSON.put(utente.toJsonObjFinale());
        }
        String text = utentiListJSON.toString();

        try (FileWriter file = new FileWriter(PATH_UTENTI)) {
            file.write(text);
            file.close();
        } catch (IOException e) {
            creaFileUtenti();
            System.out.println("Fanculo");
        }
    }

    public void scriviFileAttivita(List<Attivita> attivita) {
        JSONArray attivitaListJSON = new JSONArray();
        for (Attivita attivita2 : attivita) {
            attivitaListJSON.put(attivita2.toJsonObjFinale());
        }
        String text = attivitaListJSON.toString();

        try (FileWriter file = new FileWriter(PATH_ATTIVITA)) {
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scriviFilePrenotazioni(HashMap<Attivita, Cliente> prenotazioni) {
        JSONArray prenotazioniListJSON = new JSONArray();
        for (Entry<Attivita, Cliente> item : prenotazioni.entrySet()) {
            JSONObject object = new JSONObject();
            object.put("CodiceAttivita", item.getKey());
            object.put("Username", item.getValue());
            prenotazioniListJSON.put(object);
        }
        String text = prenotazioniListJSON.toString();

        try (FileWriter file = new FileWriter(PATH_PRENOTAZIONI)) {
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scriviFileUtentiAttivita(HashMap<Attivita, Cliente> attivitaPassate) {
        JSONArray attivitaPassateListJSON = new JSONArray();
        for (Entry<Attivita, Cliente> item : attivitaPassate.entrySet()) {
            JSONObject object = new JSONObject();
            object.put("CodiceAttivita", item.getKey());
            object.put("Username", item.getValue());
            attivitaPassateListJSON.put(object);
        }
        String text = attivitaPassateListJSON.toString();

        try (FileWriter file = new FileWriter(PATH_UTENTI_ATTIVITA)) {
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scriviFileUtentiTurni(HashMap<Attivita, Cliente> turni) {
        JSONArray turniListJSON = new JSONArray();
        for (Entry<Attivita, Cliente> item : turni.entrySet()) {
            JSONObject object = new JSONObject();
            object.put("CodiceAttivita", item.getKey());
            object.put("Username", item.getValue());
            turniListJSON.put(object);
        }
        String text = turniListJSON.toString();

        try (FileWriter file = new FileWriter(PATH_TURNI_LAVORATIVI)) {
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
