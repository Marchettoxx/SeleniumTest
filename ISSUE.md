# Alcune problematiche ritrovate sul Figma:

---
**Presupposto:** Le componenti di Figma sono state 
copiate (quasi tutte) tramite un plugin, cercando di
rispettare tutte le funzionalità presenti sul Figma.
---

1. Su figma non sono implementate molte usage ad 
esempio ci sono grafiche che non sono collegate per 
cui non possono essere utilizzate (SE CI SARA' TEMPO SI AGGIUNGERANNO ALLA FINW).
2. Inizialmente la versione headless dava problemi, ovvero i test non passavano, 
per cui è stato necessario aggungere il valore new perchè funzionassero (https://stackoverflow.com/questions/75401348/selenium-chrome-driver-headless-mode-not-working).

    Versione non funzionante:
    
        chrome_options.addArguments("--headless");
    Versione funzionante:
        
        chrome_options.addArguments("--headless=new");
3. Inizialmente si eseguivano i test andando ad allargare la dimensione
della finestra tramite perchè altrimenti i test non funzionavano, allora
è stato necessario tramite il plugin **TeleportHQ** ridurre la dimensione
delle pagine web dato che la loro dimensione era fissa e non responsive,
per cui i test non sono in grado di individuare gli elementi.

    Codice rimosso:
    
       driver.manage().window().maximize();