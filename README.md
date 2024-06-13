# Progetto di Tesi Magistrale

Tramitel'utilizzo di Selenium, un framework per il testing di pagine web, sono stati realizzati dei test su Figma e poi sono stati portati sul sito ufficiale, che è stato sviluppato durante l'esperienza di tirocinio.

## RELAZIONE PROGETTO
Relazione progetto di tesi nella seguente pagina: https://www.overleaf.com/project/664a1a9e1a75cc1600fac278.

## INTRODUZIONE
Il sito web preso in considerazione consiste in un applicativo ad uso interno per la gestione delle comunicazioni.
L'accesso a tale portale richiede delle credenziali, in base alle quali l'esperienza utente sarà diversa.
Esempio: l'utente base può visualizzare la rubrica, mentre l'utente Admin può visualizzare e inviare le comunicazioni.
Per poter testare la user experience, sono stati realizzati dei test base che eseguono sul Figma (questi test si basano sugli scenari che sono elencati successivamente) per poter costruire in modo sommario le pagine PO, che Selenium sfrutta per creare i collegamenti tra html e java. Successivamente, seguirà una fase di porting, in cui partendo dalle pagine PO realizzate sul Figma, le stesse verranno riadattate per funzionare sul sito web ufficiale.

## REQUISITI
Per poter realizzare questo progetto sono necessari: 
- una pagina Figma con l'implementazione del Design della pagina Web
- un plugin, teleporthq, per trasformare le pagine da immagini a elementi html responsive e associabili ad elementi su cui Selenium si basa.
- una applicazione in locale per la realizzazione di test tramite Selenium.
- il sito Web su cui verranno realizzati i test finali.

## SCENARI

### 1 L'UTENTE ACCEDE ALLA PAGINA PRINCIPALE 
- **Assunzione iniziale**: Non esiste una pagina di creazione dell'utente per cui si assume che l'utente sia già a conoscenza delle proprie credenziali e quindi lo stato iniziale sarà quello in cui l'utente visualizza la pagina principale, ovvero delle comunicazioni.
- **Descrizione del flow normale**: L'utente visualizza su schermo la pagina delle comunicazioni.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: L'utente visualizza il titolo della pagina.

### 2 L'UTENTE CLICCA SU CONFIGURAZIONI
- **Assunzione iniziale**: L'utente può cliccare su configurazioni per accedere alle opzioni di configurazione comunicazione.
- **Descrizione del flow normale**: L'utente nella pagina comunicazioni può premere il pulsante configurazioni.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: L'utente una volta cliccato il pulsante configurazioni andrà nella pagina di configurazione con aperto il primo tab di presa visione.

### 3 L'UTENTE PUO TORNARE ALLA PAGINA PRECEDENTE 
- **Assunzione iniziale**: L'utente può tornare alla pagina precedente.
- **Descrizione del flow normale**: L'utente cliccando sul pulsante "Comunicazioni" può tornare alla pagina precedente.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: L'utente una volta premuto il pulsante vedrà la pagina di Comunicazioni.

### 4 L'UTENTE SELEZIONA IL TAB NOTIFICHE
- **Assunzione iniziale**: L'utente può visualizzare le configurazioni delle notifiche.
- **Descrizione del flow normale**: L'utente nella pagina di presa visione può cliccare su "Notifiche" e visualizzare la pagina con le notifiche.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: Una volta cliccato il tab notifiche l'utente visualizza la pagina delle notifiche.

### 5 L'UTENTE SELEZIONA IL TAB TESTI DI DEFAULT
- **Assunzione iniziale**: L'utente può visualizzare le configurazioni dei testi.
- **Descrizione del flow normale**: L'utente nella pagina di presa visione può cliccare su "Testi di default" e visualizzare la pagina con i testi.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: Una volta cliccato il tab testi l'utente visualizza la pagina dei testi.

### 6 L'UTENTE SELEZIONA IL TAB FIRME
- **Assunzione iniziale**: L'utente può visualizzare le configurazioni delle firme.
- **Descrizione del flow normale**: L'utente nella pagina di presa visione può cliccare su "Firme" e visualizzare la pagina con le firme.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: Una volta cliccato il tab "Firme" l'utente visualizza la pagina delle firme.

### 7 L'UTENTE PUO' CLICCARE UTENTI E GRUPPI PER APRIRE GLI ELECHI
- **Assunzione iniziale**: L'utente cliccando sul menù laterale "Utenti e gruppi" visualizza la pagina "Utenti".
- **Descrizione del flow normale**: Quando l'utente clicca sul testo Utenti e gruppi visualizza l'elenco degli utenti.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: Una volta cliccato il pulsante laterale "Utenti e gruppi" l'utente visualizza la pagina "Utenti".

### 8 L'UTENTE PUO' VISUALIZZARE I DETTAGLI DELL'UTENTE
- **Assunzione iniziale**: L'utente cliccando sulla riga dell'utente può visualizzare i dettagli dello stesso.
- **Descrizione del flow normale**: L'utente visualizza le righe degli utenti può cliccando sulla riga visualizzare i dettagli.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: Una volta che l'utente ha cliccato un utente visualizza la pagina dettaglio utente.

### 9 L'UTENTE PUO' CLICCARE IL TAB GRUPPI PER VISUALIZZARE L'ELENCO DEI GRUPPI
- **Assunzione iniziale**: L'utente cliccando sul tab "Gruppi" visualizza i gruppi di utenti.
- **Descrizione del flow normale**: Quando l'utente clicca il tab "Gruppi" apre l'elenco dei gruppi.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: Una volta che l'utente ha cliccato sul tab "Gruppi" visualizza l'elenco dei gruppi.

### 10 L'UTENTE PUO' VISUALIZZARE I DETTAGLI DEL GRUPPO
- **Assunzione iniziale**: L'utente cliccando sulla riga del gruppo può visualizzare i dettagli dello stesso.
- **Descrizione del flow normale**: L'utente visualizza le righe dei gruppi può cliccando sulla riga visualizzare i dettagli.
- **Descrizione dei problemi possibili**: -
- **Stato del sistema al completamento**: Una volta che l'utente ha cliccato un gruppo visualizza la pagina dettaglio gruppo.

## ASSUNZIONI DI PROGETTAZIONE

## DOCUMENTAZIONE

### METODOLOGIA DI SVILUPPO
Ho adottato una metodologia di sviluppo Agile di tipo incrementale per garantire una consegna rapida del progetto e un'evoluzione continua del software. Questo approccio mi ha permesso di integrare le fasi di progettazione, specifica e implementazione. Ho eseguito brevi iterazioni, producendo diverse versioni del progetto per mantenere una visione costante del prodotto finale. Lo sviluppo incrementale mi ha consentito di apportare modifiche al codice con facilità. Inoltre, questo metodo riduce al minimo la documentazione necessaria, evitando di dover registrare ogni singola versione del codice realizzata.
Ogni giorno ho monitorato le attività svolte e in corso, oltre a risolvere vari problemi di sviluppo. Ho utilizzato Git come sistema di versionamento e GitHub come piattaforma per la condivisione del codice, garantendo una comprensione completa di ogni modifica apportata al codice.

### CHECKING
Il codice è stato costantemente rivisto, si è cercato
d'identificare le componenti di codice incorretto o che
può essere migliorato. Inoltre sono stati fatti molteplici
controlli sull'indentazione e sulla nomenclatura del codice
andando a eseguire refactoring.

### UNIT TESTING

### SYSTEM TESTING

#### Test crea utente
Andiamo a verificare tutti i possibili errori che un utente può fare nella creazione del suo nuovo account e anche il 
corretto inserimento di tutti i parametri.
1. Viene creata nuova persona in cui viene lasciato in bianco il campo relativo al nome. 
Verifico che l'account non sia stato creato e venga chiesto d'inserire nuovamente le credenziali.
2. Viene creata nuova persona in cui viene lasciato in bianco il campo relativo al cognome.
Verifico che l'account non sia stato creato e venga chiesto d'inserire nuovamente le credenziali.
3. Viene creata nuova persona in cui viene inserita una mail non valida.
Verifico che l'account non sia stato creato e venga chiesto d'inserire nuovamente le credenziali. 
4. Viene creata nuova persona in cui viene inserito un username non valido.
Verifico che l'account non sia stato creato e venga chiesto d'inserire nuovamente le credenziali. 
5. Viene creata nuova persona in cui viene inserita una password che non rispetta i requisiti richiesti.
Verifico che l'account non sia stato creato e venga chiesto d'inserire nuovamente le credenziali. 
6. Viene creata nuova persona con le credenziali corrette (i valori rispettano i requisiti stabiliti). 
Verifico che l'account sia stato effettivamente creato. 
7. Viene creata nuova persona e viene scelto un username già esistente.
Verifico che l'account non sia stato creato e venga chiesto d'inserire nuovamente le credenziali.
8. Viene creata nuova persona diverso da quello creato nel test numero sei. 
Verifico che l'account venga effettivamente creato.

#### Test Login
1. Eseguo il login inserendo un username errato. Verifico di non aver fatto il login.
2. Eseguo il login inserendo una password errata. Verifico di non aver fatto il login.
3. Eseguo il login inserendo sia l'username che la password errati. Verifico di non aver fatto il login. 
4. Eseguo il login con le credenziali corrette. Verifico che il login sia avvenuto con successo e di essere nella pagina home.

#### Test pagina Home
1. Premo il tasto Profilo e verifico di essere entrato effettivamente nella pagina desiderata.
2. Premo il tasto Pompa Insulinica e verifico di essere entrato effettivamente nella pagina desiderata.
3. Premo il tasto Cronologia e verifico di rimanere nella pagina Home, 
in quanto non avendo ancora fatto nessuna iniezione la cronologia sarà vuota.

#### Test Profilo
1. Modifico il nome in modo errato e verifico che la modifica non sia avvenuta.
2. Modifico il cognome in modo errato e verifico che la modifica non sia avvenuta.
3. Modifico il l'email in modo errato e verifico che la modifica non sia avvenuta.
4. Modifico l'username in modo errato e verifico che la modifica non sia avvenuta.
5. Modifico l'username utilizzandone uno già esistente. Verifico quindi che la modifica non sia avvenuta.
6. Modifico la password in modo errato e verifico che la modifica non sia avvenuta.
7. Modifico la mail in modo corretto. Verifico che la modifica sia avvenuta con successo.
8. Modifico l'username in modo corretto. Verifico che la modifica sia avvenuta con successo.
9. Premo il tasto indietro presente nella pagina Modifica Credenziali Utente e verifico di essere tornato nella pagina Profilo.

#### Test Pompa Insulinica
1. Inserisco una nuova misurazione. Nel campo glicemia si inserisce un valore sbagliato (non compreso tra 100 e 300). 
Verifico che la registrazione non sia andata a buon fine.
2. Inserisco una nuova misurazione. Nel campo glicemia si inserisce un valore non numerico.
Verifico che la registrazione non sia andata a buon fine.
3. Inserisco una nuova misurazione. Nel campo glicemia si inserisce un valore vuoto.
Verifico che la registrazione non sia andata a buon fine.
4. Inserisco una nuova misurazione. Nel campo insulina si inserisce un valore che non rispetta i requisiti.
Verifico che la registrazione non sia andata a buon fine.
5. Inserisco una nuova misurazione. Nel campo insulina si inserisce un valore in lettere.
Verifico che la registrazione non sia andata a buon fine.
6. Inserisco una nuova misurazione. Lascio il valore relativo all'insulina vuoto.
Verifico che la registrazione non sia andata a buon fine.
7. Inserisco una nuova misurazione. Inserisco un commento che non rispetta i requisiti.
Verifico che la registrazione non sia andata a buon fine.
8. Inserisco una nuova misurazione. Inserisco la glicemia, l'insulina e il commento rispettando i requisiti richiesti.
Verifico che la registrazione sia stata fatta correttamente.
9. Premo il tasto indietro presente nella pagina Pompa Insulinica e verifico di essere tornato alla pagina Home.

#### Test Cronologia
1. Controllo che la misurazione appena fatta sia presente in cronologia e verifico che usando il tasto "Cancella" 
questa riga venga eliminata.
2. Inserisco una misurazione, controllo che questa sia presente in cronologia e premo il tasto "Cancella tutto".
Verifico che non sia più presente nulla nella cronologia.
3. Premo il tasto indietro presente nella pagina Cronologia e verifico di essere tornato alla pagina Home.

#### Test Logout
1. Controllo che dalla pagina home se schiaccio il pulsante "Logout" l'utente viene reindirizzato alla pagina di login.

#### Test Elimina Utente
1. Controllo che una volta nella pagina Profilo se si preme il tasto "Elimina account" si venga reindirizzati nella pagina di Login.
Verifico che l'account sia stato effettivamente eliminato provando a eseguire nuovamente il login.
2. Lo faccio anche con l'altro account che mi ero creato e in cui nel corso dei test ho modificato l'username, in modo da non 
avere un errore (username già utilizzato) se dovessi rifare i test in futuro.

### COVERAGE

### TESTING DI ACCETTAZIONE
