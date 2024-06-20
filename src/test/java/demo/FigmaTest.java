package demo;

import PO.*;
import model.UserType;
import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        String password = "ESGJ3P";

        driver.get(url);
        driver.manage().window().maximize();

        LoginPO loginPO = new LoginPO(driver);
        SelectUserPO selectUserPO = loginPO.login(password);
        return selectUserPO.selectUserType(userType);
    }

    // Test per vedere se cliccando su una comunicazione si aprono i dettagli
    // e si può tornare indietro tramite la breadcrumb
    @Test
    public void detailCommunicationTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    // TODO: creare un test come quello precedente, facendo il ritorno dal tasto della barra laterale

    // Test per vedere se cliccando su una comunicazione si aprono i dettagli
    // e cliccando su "Nuovo messaggio" si può aprire la chat e richiudere
    // e si può tornare indietro tramite la breadcrumb
    @Test
    public void chatCommunicationTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        ChatPO chatPO = communicationDetailPO.openChat();

        String titleChat = chatPO.getTitle();
        assertEquals("Chat con ABI 08016", titleChat);

        CommunicationDetailPO communicationDetailPO1 = communicationPO.clickDetail();

        String titleDetailCommunicationFromChat = communicationDetailPO1.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunicationFromChat);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    // Test per vedere se dopo aver cliccato il bottone configura compare la
    // pagina di configurazione e si può tornare indietro
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

    // Test per vedere se cliccando su modifica si apre la pagina di modifica e cliccando salva
    // si torna alla pagina precedente
    @Test
    public void DAdminTest() throws InterruptedException {
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

    // Test per vedere se cliccando sul tab notifiche si finisce sulla pagina delle notifiche
    @Test
    public void EAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);
    }

    // Test per vedere se cliccando su nuova notifica si apre la
    // pagina di creazione e salvando si torna indietro
    @Test
    public void FAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationCreatePO notificationCreatePO = notificationPO.createNotification();

        String confirmButtonText = notificationCreatePO.getTitle();
        assertEquals("Nuova notifica", confirmButtonText);

        NotificationPO notificationPO1 = notificationCreatePO.confirm();

        String titleNotificationConfirm = notificationPO1.getTitle();
        assertEquals("Notifiche", titleNotificationConfirm);
    }

    // Test per vedere se cliccando su una notifica si apre il dettaglio
    @Test
    public void GAdminTest()  {
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

    // Test per vedere se cliccando su una modifica si apre la pagina di modifica
    // e salvando si torna indietro
    @Test
    public void HAdminTest() throws InterruptedException {
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
    // apre la pagina dei testi
    @Test
    public void IAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);
    }

    // Test per vedere se cliccando sul tab delle firme si
    // apre la pagina delle firme
    @Test
    public void JAdminTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);
    }

    @Test
    public void KAdminTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);
    }

    @Test
    public void LAdminTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserDetailPO userDetailPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = userDetailPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);
    }

    @Test
    public void MAdminTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);
    }

    @Test
    public void NAdminTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        GroupDetailPO groupDetailPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = groupDetailPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);
    }

    // Test per vedere se cliccando su una comunicazione si aprono i dettagli
    // e si può tornare indietro
    @Test
    public void ABankTest() {
        CommunicationPO communicationPO = this.login(UserType.BANK);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    // Test per vedere se cliccando su rubrica si apre la rubrica
    @Test
    public void BBankTest() {
        CommunicationPO communicationPO = this.login(UserType.BANK);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        AddressBookPO addressBookPO = communicationPO.clickAddressBook();

        String titleAddressBook = addressBookPO.getTitle();
        assertEquals("Rubrica", titleAddressBook);
    }

    // Test per vedere se cliccando modifica si apre la pagina di modifica
    // e cliccando annulla appare la schermata iniziale
    @Test
    public void CBankTest() {
        CommunicationPO communicationPO = this.login(UserType.BANK);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        AddressBookPO addressBookPO = communicationPO.clickAddressBook();

        String titleAddressBook = addressBookPO.getTitle();
        assertEquals("Rubrica", titleAddressBook);

        AddressBookEditPO addressBookEditPO = addressBookPO.edit();

        String saveButtonText = addressBookEditPO.getCancelButtonText();
        assertEquals("ANNULLA", saveButtonText);

        AddressBookPO addressBookPO1 = addressBookEditPO.cancel();

        String titleAddressBookEdit = addressBookPO1.getTitle();
        assertEquals("Rubrica", titleAddressBookEdit);
    }

    // Test per vedere se cliccando nuovo contatto si apre la pagina di creazione
    // e cliccando salva appare la schermata iniziale
    @Test
    public void DBankTest() {
        CommunicationPO communicationPO = this.login(UserType.BANK);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        AddressBookPO addressBookPO = communicationPO.clickAddressBook();

        String titleAddressBook = addressBookPO.getTitle();
        assertEquals("Rubrica", titleAddressBook);

        AddressBookCreatePO addressBookCreatePO = addressBookPO.create();

        String saveButtonText = addressBookCreatePO.getTitle();
        assertEquals("Crea nuovo contatto", saveButtonText);

        AddressBookPO addressBookPO1 = addressBookCreatePO.create();

        String titleAddressBookEdit = addressBookPO1.getTitle();
        assertEquals("Rubrica", titleAddressBookEdit);
    }
}
