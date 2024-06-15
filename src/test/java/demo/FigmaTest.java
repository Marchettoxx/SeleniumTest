package demo;

import PO.*;
import model.UserType;
import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FigmaTest {

    private WebDriver driver;
    @Before
    public void setUp() {
        ChromeOptions chrome_options = new ChromeOptions();
        //chrome_options.addArguments("--headless");
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

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public CommunicationPO login(UserType userType) {
        String url = "https://testselenium.teleporthq.app/";
        driver.get(url);

        driver.manage().window().maximize();

        // Riduzione zoom, non funzionante
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("document.body.style.zoom = '50%'");

        LoginPO loginPO = new LoginPO(driver);
        String password = "ESGJ3P";

        SelectUserPO selectUserPO = loginPO.login(password);
        CommunicationPO communicationPO = null;
        try {
            communicationPO = selectUserPO.selectUserType(userType);
        } catch (InterruptedException e) {
            // errore
        }

        return communicationPO;
    }

    // Test se la pagina corrisponde a quella delle comunicazioni
    @Test
    public void AAdminTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);
    }

    // Test per vedere se cliccando su una comunicazione si aprono i dettagli
    @Test
    public void AAAdminTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        DetailCommunicationPO detailCommunicationPO = communicationPO.clickDetail();

        String titleDetailCommunication = detailCommunicationPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);
    }

    // Test per vedere se da dettagli si può tornare alla pagina precedente
    @Test
    public void AABdminTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        DetailCommunicationPO detailCommunicationPO = communicationPO.clickDetail();

        String titleDetailCommunication = detailCommunicationPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationPO communicationPO1 = detailCommunicationPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    // Test per vedere se dopo aver cliccato il bottone configura compare la pagina di configurazione
    @Test
    public void BAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);
    }

    // Test per vedere se cliccando su modifica si apre la pagina di modifica
    @Test
    public void BAAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        AcknowledgeEditPO acknowledgeEditPO = configurationPO.clickEditAcknowledge();

        String buttonSaveText = acknowledgeEditPO.getSaveButtonText();
        assertEquals("SALVA", buttonSaveText);
    }

    // Test per vedere se cliccando salva si torna alla pagina di configurazione
    @Test
    public void BBAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        AcknowledgeEditPO acknowledgeEditPO = configurationPO.clickEditAcknowledge();

        String buttonSaveText = acknowledgeEditPO.getSaveButtonText();
        assertEquals("SALVA", buttonSaveText);

        ConfigurationPO configurationPO1 = acknowledgeEditPO.clickSave();

        String titleConfigurationSave = configurationPO1.getTitle();
        assertEquals("Configurazione", titleConfigurationSave);
    }

    // Test per vedere cliccando in comunicazioni si può tornare da configurazione in
    // comunicazioni
    @Test
    public void CAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        CommunicationPO communicationPO1 = configurationPO.clickCommunication();

        String titleCommunication = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunication);
    }

    // Test per vedere se cliccando sul tab notifiche si finisce sulla pagina delle notifiche
    @Test
    public void DAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);
    }

    // Test per vedere se cliccando su nuova notifica si apre la
    // pagina di creazione
    @Test
    public void DAAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationEditPO notificationEditPO = notificationPO.createNotification();

        String confirmButtonText = notificationEditPO.getSaveButtonText();
        assertEquals("CONFERMA", confirmButtonText);
    }

    // Test per vedere se cliccando su conferma si apre la pagina
    // di visione delle notifiche
    @Test
    public void DBAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationEditPO notificationEditPO = notificationPO.createNotification();

        String confirmButtonText = notificationEditPO.getSaveButtonText();
        assertEquals("CONFERMA", confirmButtonText);

        NotificationPO notificationPO1 = notificationEditPO.save();

        String titleNotificationConfirm = notificationPO1.getTitle();
        assertEquals("Notifiche", titleNotificationConfirm);
    }

    // Test per vedere se cliccando su una notifica si apre il dettaglio
    @Test
    public void DCAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationDetailPO notificationDetailPO = notificationPO.clickDetail();

        String titleNotificationDetail = notificationDetailPO.getTitle();
        assertEquals("[Descrizione notifica]", titleNotificationDetail);
    }

    // Test per vedere se cliccando su una modific si apre la pagina di modifica
    @Test
    public void DDAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationDetailPO notificationDetailPO = notificationPO.clickDetail();

        String titleNotificationDetail = notificationDetailPO.getTitle();
        assertEquals("[Descrizione notifica]", titleNotificationDetail);

        NotificationEditPO notificationEditPO = notificationDetailPO.edit();

        String buttonSaveText = notificationEditPO.getSaveButtonText();
        assertEquals("SALVA", buttonSaveText);
    }

    // Test per vedere se cliccando su salva si apre la notifiche
    @Test
    public void DEAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationDetailPO notificationDetailPO = notificationPO.clickDetail();

        String titleNotificationDetail = notificationDetailPO.getTitle();
        assertEquals("[Descrizione notifica]", titleNotificationDetail);

        NotificationEditPO notificationEditPO = notificationDetailPO.edit();

        String buttonSaveText = notificationEditPO.getSaveButtonText();
        assertEquals("SALVA", buttonSaveText);

        NotificationPO notificationPO1 = notificationEditPO.save();

        String titleNotificationSave = notificationPO1.getTitle();
        assertEquals("Notifiche", titleNotificationSave);
    }

    // Test per vedere se cliccando sul tab dei testi di default si
    // apre la pagina giusta
    @Test
    public void EAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);
    }

    // Test per vedere se cliccando sul tab delle firme si
    // apre la pagina giusta
    @Test
    public void FAdminTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);
    }

    @Test
    public void GAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);
    }

    @Test
    public void HAdminTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        DetailUserPO detailUserPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = detailUserPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);
    }

    @Test
    public void IAdminTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);
    }

    @Test
    public void JAdminTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        DetailGroupPO detailGroupPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = detailGroupPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);
    }
}
