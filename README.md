# PROGETTO DI TESI MAGISTRALE

Tramite l'utilizzo di Selenium, un framework per il testing di pagine web, sono stati realizzati dei test su Figma e poi sono stati portati sul sito ufficiale, che è stato sviluppato durante l'esperienza di tirocinio.

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

### U/X TESTING

#### Test comunicazioni
- Verifico che il titolo della pagina corrisponda a "Comunicazioni".

#### Test Configurazioni
- Verifico che se l'utente clicca sul pulsante configurazioni il titolo della pagina aperto sia "Configurazioni"
- Verifico che se l'utente in "Configurazoni" clicca su "Comunicazioni" può tornare alla pagina delle comunicazioni.
- Verifico che se l'utente clicca sul tab delle notifiche verrà aperta la pagina delle notifiche verificando il nome della prima notifica.
- Verifico che se l'utente clicca sul tab dei testi verrà aperta la pagina dei testi verificando il nome del primo testo.
- Verifico che se l'utente clicca sul tab delle firme verrà aperta la pagina delle firme verificando il nome della prima firma.

#### Test Utenti e gruppi
- Verifico che se l'utente clicca su "Utenti e gruppi" la pagina aperta avrà titolo "Utenti e gruppi".
- Verifico che se l'utente cliccando sul primo utente dell'elenco venga aperta la pagina dei dettagli verificando che il titolo sia quello corretto.
- Verifico che se l'utente clicca il tab "Gestione gruppi" nella pagina aperta sia presente il pulsante "NUOVO GRUPPO".
- Verifico che se l'utente cliccando sul primo grupppo dell'elenco venga aperta la pagina dei dettagli verificando che il titolo sia quello corretto.
