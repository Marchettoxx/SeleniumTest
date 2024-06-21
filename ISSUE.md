# Alcune problematiche ritrovate sul Figma:

1. Selenium inizialmente doveva eseguire su Figma, ma Figma non espone gli 
elementi html, per cui tramite un plugin chiamato **TeleportHQ** (https://play.teleporthq.io/projects/1-portali-sprint-1-workflow-comunicazioni-uiux-27nnss), sono stati copiate
tutte le pagine presenti su Figma e sono stati aggiunti i collegamenti tra le pagine
come ad esempio le azioni di click di un pulsante. Sono state copiate tutte le interazioni
che i designer di Figma hanno realizzato, in modo tale da emulare un contesto lavorativo.
2. Su figma non sono implementate molte usage ad 
esempio ci sono grafiche che non sono collegate per 
cui non possono essere utilizzate (SE CI SARA' TEMPO SI AGGIUNGERANNO ALLA FINW).
3. Inizialmente la versione headless dava problemi, ovvero i test non passavano, 
per cui è stato necessario aggungere il valore new perchè funzionassero (https://stackoverflow.com/questions/75401348/selenium-chrome-driver-headless-mode-not-working).

    Versione non funzionante:
    
        chrome_options.addArguments("--headless");
    Versione funzionante:
        
        chrome_options.addArguments("--headless=new");
4. Inizialmente si eseguivano i test andando ad allargare la dimensione
della finestra tramite perchè altrimenti i test non funzionavano, allora
è stato necessario tramite il plugin **TeleportHQ** ridurre la dimensione
delle pagine web dato che la loro dimensione era fissa e non responsive,
per cui i test non sono in grado di individuare gli elementi.

    Codice rimosso:
    
       driver.manage().window().maximize();
5. Inizialmente il driver di chrome veniva preso in locale, per cui ad ogni aggiornamento del driver di chrome
era necessario installare un nuovo driver per farlo funzionare, per evitare di fare questo è 
stato installato un webdrivermanager per la gestione dei driver. (https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.8.0, https://github.com/bonigarcia/webdrivermanager?tab=readme-ov-file).

    Codice vecchio:
    
        public void setUp() {
            ChromeOptions chrome_options = new ChromeOptions();
            //chrome_options.addArguments("--headless=new");
            if(SystemUtils.IS_OS_WINDOWS){
                System.setProperty("webdriver.chrome.driver",
                        Paths.get("src/test/resources/chromedriver_win32_96/chromedriver.exe").toString());
            }
            else if (SystemUtils.IS_OS_MAC){
                System.setProperty("webdriver.chrome.driver",
                        Paths.get("src/test/resources/chromedriver_mac64_96/chromedriver").toString());
            }
            else if (SystemUtils.IS_OS_LINUX){
                System.setProperty("webdriver.chrome.driver",
                        Paths.get("src/test/resources/chromedriver_linux64_96/chromedriver").toString());
            }
            if (driver == null) {
                driver = new ChromeDriver(chrome_options);
            }
        }
6. 