# ProgettoProgOggVigna
 questo progetto è un progetto di esame per "Programmazione ad Oggetti" che si pone come obiettivo la creazione di un gestionale di un'azienda agricola

# ATTIVITÀ PERMESSE
 all'interno dell'azienda saranno concesse due tipologie di attività:
 • Visita alle vigne
 • Degustazione di vini 

 La visita alle vigne sarà assegnata ad un dipendente (una Guida) che prenderà il gruppo in carico, segnerà presenze ed assenze e condurrà l'esperienza. Una visita potrà essere più o meno approfondita facendo variare il costo dell'esperienza. Il livello di dettaglio tenuto dalla guida sarà quindi identificato dal "pacchetto esperienza" scelto. Logicamente più una visita sarà lunga più approfondita sarà mettendo in conto interventi dei dipendenti più specializzati della guida e prevedendo anche attività di partecipazione attiva del visitatore

 La degustazione di vini sarà assegnata ad un dipendente (un Somelier) che prenderà il gruppo in carico, segnerà presenze ed assenze e condurrà l'esperienza. Una degustazione potrà prevedere dei vini più o meno pregiati e una quantità di assaggi più o meno sostanziosa facendo variare il prezzo dell'esperienza. Il livello della degustazione sarà quindi identificato dal "pacchetto esperienza" scelto.

 Sarà inifine possibile prenotare dei pacchetti attività che prevederanno combinazioni di attività dello stesso livello di pacchetto o esperienze più intime riservando le attività per se stessi

 # ENTITÀ DEL PROGRAMMA
 all'interno del programma sono presenti entità attive (Admin, Utente, Somelier, Guida, Cliente) ed entità passive (Prenotazione, Visita, Degustazione)

 Admin: l'entità admin identifica il "capo" della tenuta. Questo avrà la facoltà di 
 • visualizzare tutte le attività schedulate assegnate e non ad un dipendente
 • visualizzare tutte le attività giorno per giorno avvenute nella tenuta
 • assegnare attività ai vari dipendenti
 • segnalare contatti con contagiati covid via mail con tutti i presenti al momento del contagio
 • visualizzare gli introiti

 Guida: l'entità guida identifica un dipendente specializzato nell'illustrazione delle attività inerenti l'azienda. Questa avrà la facoltà di:
 • visualizzare i propri turni (assegnati dal capo)
 • avviare un'attività (segnare presenti e assenti ed iniziare il tour)
 • visualizzare lo storico di tutte le attività da lei svolte

 Somelier: l'entità somelier identifica un dipendente specializzato nella degustazione dei vini. Questa avrà la facoltà di:
 • visualizzare i propri turni (assegnati dal capo)
 • avviare un'attività (segnare presenti e assenti ed iniziare la degustazione)
 • visualizzare lo storico di tutte le attività da lei svolte

 Cliente: l'entità cliente identifica una persona che vuole usufruire delle attività messe a disposizione dall'azienda. Questa potrà:
 • registrarsi sull'applicativo
 • prenotare un'attività o un pacchetto attività
 • visualizzare lo storico di tutte le attività a cui ha partecipato

 I pagamenti vengono gestiti in modo implicito (se un cliente è presente durante un'attività si intende cha ha pagato)

# UTILIZZO DEL PROGRAMMA
Per poter utilizzare il programma è necessario installare le dipendenze per l'utilizzo dei file JSON. Per comodità queste sono state aggiunte al progetto sotto forma di file jar. 
