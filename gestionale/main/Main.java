package gestionale.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import gestionale.controller.GestioneFile;
import gestionale.entities.Attivita;
import gestionale.entities.Cliente;
import gestionale.entities.Utente;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static List<Utente> utenti = new ArrayList<>();
    private static List<Cliente> clienti = new ArrayList<>();
    private static List<Attivita> attivita = new ArrayList<>();
    private static HashMap<Attivita, Cliente> prenotazioni = new HashMap<>();
    private static HashMap<Attivita, Utente> turni = new HashMap<>();
    private static HashMap<Attivita, Cliente> prenotazioniPassate = new HashMap<>();

    public static void main(String[] args) {
        loadDati();
        benvenuto();
    }

    private static void benvenuto() {
        System.out.println("BENVENUTO NELLA VIGNAMAGNA, ESEGUI IL LOGIN!");
        System.out.println("DIGITA: ");
        System.out.println("1) PER ESEGUIRE IL LOGIN");
        System.out.println("2) PRE CREARE UN UTENTE");
        System.out.println("3) PER USCIRE");
        System.out.println("");
        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    login();
                }
                    break;
                case 2: {
                    creaUtente();
                }
                    break;
                case 3: {
                    arrivederci();
                }
                    break;
                default: {
                    System.out.println("");
                    System.out.println("HAI INSERITO UN VALORE ERRATO");
                    System.out.println("");
                    benvenuto();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("HAI INSERITO UN VALORE ERRATO");
            System.out.println("");
            benvenuto();
        }
    }

    private static void arrivederci() {
    }

    private static void creaUtente() {
    }

    private static void login() {
        System.out.println("");
        System.out.println("INSERISCI USERNAME O EMAIL");
        System.out.println("");
        String inserimento = scanner.nextLine();
        Boolean successo = false;
        for (Utente utente : utenti) {
            if (utente.getMail().equals(inserimento) || utente.getUsername().equals(inserimento)) {
                successo = true;
                System.out.println("");
                System.out.println("INSERISCI PASSWORD");
                System.out.println("");
                String password = scanner.nextLine();
                while (!utente.getPassword().equals(password)) {
                    System.out.println("");
                    System.out.println("PASSWORD ERRATA. RITENTA O PREMI ZERO (0) PER TORNARE INDIETRO");
                    System.out.println("");
                    password = scanner.nextLine();
                    if (password.equals("0")) {
                        benvenuto();
                    }
                }
                if (utente.getClass().equals(Cliente.class)) {
                    primaPaginaCliente();
                } else {
                    primaPaginaDipendente();
                }
                break;
            }
        }
        if (!successo) {
            System.out.println("");
            System.out.println("NON ESISTE NESSUN UTENTE ASSOCIATO A QUESTO VALORE!");
            System.out.println("");
            benvenuto();
        }
    }

    private static void primaPaginaDipendente() {
        System.out.println("BELLA FRAAAA");
    }

    private static void primaPaginaCliente() {
        System.out.println("BELLA ZIII");
    }

    private static void loadDati() {
        utenti = GestioneFile.getInstance().leggiFileUtenti();
        separaClienti();
        attivita = GestioneFile.getInstance().leggiFileAttivita(clienti);
        prenotazioni = GestioneFile.getInstance().leggiFilePrenotazioni(clienti, attivita);
        prenotazioniPassate = GestioneFile.getInstance().leggiFileUtentiAttivita(clienti, attivita);
        turni = GestioneFile.getInstance().leggiFileTurniLavorativi(utenti, attivita);
    }

    private static void separaClienti() {
        for (Utente utente : utenti) {
            if (utente.getClass().equals(Cliente.class)) {
                clienti.add((Cliente) utente);
            }
        }
    }
}