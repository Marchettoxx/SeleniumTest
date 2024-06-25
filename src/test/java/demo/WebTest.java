package demo;

import PO.web.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.UserTypeEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * The type Web test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebTest {

    private WebDriver driver;

    /**
     * Set up del driver.
     */
    @Before
    public void setup() {
        ChromeOptions chrome_options = new ChromeOptions();
        //chrome_options.addArguments("--headless=new");
        if (driver == null) {
            driver = WebDriverManager.chromedriver().capabilities(chrome_options).create();
        }
    }

    /**
     * Chiusura del driver.
     */
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Funzione per la realizzazione del login.
     *
     * @param userTypeEnum the user type enum
     * @return the communication po
     */
    public CommunicationPO login(UserTypeEnum userTypeEnum) {
        String url = "https://pwm.sviluppo.servizi.allitude.it/pwm-host-home";
        String password = "K9QATRfu!e";

        driver.get(url);

        LoginPO loginPO = new LoginPO(driver);
        HomePO homePO = loginPO.login(userTypeEnum.getUsername(), password);

        CommunicationPO communicationPO = homePO.goToCommunicationPage();

        String titleCommunicationBack = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);

        return communicationPO;
    }

    // ------------------------------------------------------------------------------------
    // TEST UTENTE TIPOLOGIA ADMIN
    // ------------------------------------------------------------------------------------

    /**
     * Test azione di visualizzazione dettaglio comunicazione e di ritorno alla pagina precedente.
     */
    @Test
    public void communicationDetailBreadCrumbAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

//        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();
//
//        String titleDetailCommunication = communicationDetailPO.getTitle();
//        assertEquals("[Nome comunicazione]", titleDetailCommunication);
//
//        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();
//
//        String titleCommunicationBack = communicationPO1.getTitle();
//        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di creazione comunicazione e selezione utenti e ritorno alla pagina precedente.
     */
    @Test
    public void communicationCreateAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        CommunicationCreatePO communicationCreatePO = communicationPO.create();

        String titleCreateCommunication = communicationCreatePO.getTitle();
        assertEquals("Nuova comunicazione", titleCreateCommunication);

        CommunicationSelectUserPO communicationSelectUserPO = communicationCreatePO.select();

        String titleSelectUser = communicationSelectUserPO.getTitle();
        assertEquals("Seleziona gli utenti destinatari della comunicazione", titleSelectUser);

        CommunicationCreatePO communicationCreatePO1 = communicationSelectUserPO.confirm();

        String titleDetailCommunicationSelect = communicationCreatePO1.getTitle();
        assertEquals("Nuova comunicazione", titleDetailCommunicationSelect);

        CommunicationPO communicationPO1 = communicationCreatePO1.cancel();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di apertura chat nel dettaglio comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void chatCommunicationAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        ChatPO chatPO = communicationDetailPO.openChat();

        String titleChat = chatPO.getTitle();
        assertEquals("Chat con ABI 08016", titleChat);

        CommunicationDetailPO communicationDetailPO1 = chatPO.closeChat();

        String titleDetailCommunicationFromChat = communicationDetailPO1.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunicationFromChat);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione apertura configurazione e ritorno alla pagina precedente.
     */
    @Test
    public void configurationAdminTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        CommunicationPO communicationPO1 = configurationPO.clickCommunication();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione apertura modifica di una comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void acknowledgmentEditAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

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

    /**
     * Test azione di apertura tab Notifiche e ritorno alla pagina precedente.
     */
    @Test
    public void notificationTabAdminTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        ConfigurationPO configurationPO1 = notificationPO.backToCommunication();

        String titleCommunicationBack = configurationPO1.getTitle();
        assertEquals("Configurazione", titleCommunicationBack);
    }

    /**
     * Test azione apertura dettaglio notifica e ritorno alla pagina precedente.
     */
    @Test
    public void notificationDetailAdminTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationDetailPO notificationDetailPO = notificationPO.clickDetail();

        String titleNotificationDetail = notificationDetailPO.getTitle();
        assertEquals("[Descrizione notifica]", titleNotificationDetail);

        NotificationPO notificationPO1 = notificationDetailPO.back();

        String titleNotificationBack = notificationPO1.getTitle();
        assertEquals("Notifiche", titleNotificationBack);
    }

    /**
     * Test azione apertura modifica notifica e ritorno alla pagina precedente.
     */
    @Test
    public void notificationEditAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

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

    /**
     * Test azione di apertura creazione notifica e ritorno alla pagina precedente.
     */
    @Test
    public void notificationCreateAdminTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

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

    /**
     * Test azione apertura tab dei testi e ritono alla pagina precedente.
     */
    @Test
    public void textTabAdminTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);

        ConfigurationPO configurationPO1 = textPO.back();

        String titleConfigurationBack = configurationPO1.getTitle();
        assertEquals("Configurazione", titleConfigurationBack);
    }

    /**
     * Test azione di apertura modifica testo e ritorno alla pagina precedente.
     */
    @Test
    public void textEditAdminTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);

        TextEditPO textEditPO = textPO.edit();

        String saveButtonText = textEditPO.getSaveButtonText();
        assertEquals("SALVA", saveButtonText);

        TextPO textPO1 = textEditPO.save();

        String firstTextSave = textPO1.getFirstText();
        assertEquals("Alert normativo", firstTextSave);
    }

    /**
     * Test azione di apertura tab delle firme e ritorno alla pagina precedente.
     */
    @Test
    public void signatureTabAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);

        ConfigurationPO configurationPO1 = signaturePO.back();

        String titleConfigurationBack = configurationPO1.getTitle();
        assertEquals("Configurazione", titleConfigurationBack);
    }

    /**
     * Test azione di apertura pagina di modifica firma e ritorno alla pagina precedente.
     */
    @Test
    public void signatureEditAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);

        SignatureEditPO signatureEditPO = signaturePO.edit();

        String saveButtonText = signatureEditPO.getSaveButtonText();
        assertEquals("SALVA", saveButtonText);

        SignaturePO signaturePO1 = signatureEditPO.save();

        String firstSignatureSave = signaturePO1.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignatureSave);
    }

    /**
     * Test azione di apertura creazione firma e ritorno alla pagina precedente.
     */
    @Test
    public void signatureCreateAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);

        SignatureCreatePO signatureCreatePO = signaturePO.create();

        String saveButtonText = signatureCreatePO.getTitle();
        assertEquals("Crea nuova firma", saveButtonText);

        SignaturePO signaturePO1 = signatureCreatePO.save();

        String firstSignatureSave = signaturePO1.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignatureSave);
    }

    /**
     * Test azione di apertura dettaglio utente e ritorno alla pagina precedente.
     */
    @Test
    public void UserDetailBreadCrumbAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserDetailPO userDetailPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = userDetailPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);

        UsersAndGroupsPO usersAndGroupsPO1 = userDetailPO.backBreadCrumb();

        String titleUsersAndGroupsDetail = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsDetail);
    }

    /**
     * Test azione di apertura dettaglio utente e ritorno alla pagina precedente tramite side bar.
     */
    @Test
    public void UserDetailSideMenuAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserDetailPO userDetailPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = userDetailPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);

        UsersAndGroupsPO usersAndGroupsPO1 = userDetailPO.back();

        String titleUsersAndGroupsDetail = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsDetail);
    }

    /**
     * Test azione di apertura modifica utente e ritorno alla pagina precedente.
     */
    @Test
    public void UserEditAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserDetailPO userDetailPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = userDetailPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);

        UserEditPO userEditPO = userDetailPO.edit();

        String titleUserEdit = userEditPO.getTitle();
        assertEquals("Dettaglio utente", titleUserEdit);

        UsersAndGroupsPO usersAndGroupsPO1 = userEditPO.save();

        String titleUserDetailEdit = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUserDetailEdit);
    }

    /**
     * Test azione di apertura creazione utente e ritorno alla pagina precedente.
     */
    @Test
    public void UserCreateAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserCreatePO userCreatePO = usersAndGroupsPO.create();

        String titleNewUser = userCreatePO.getTitle();
        assertEquals("Nuovo utente", titleNewUser);

        UserAddToGroupPO userAddToGroupPO = userCreatePO.add();

        String titleAddGroup = userAddToGroupPO.getTitle();
        assertEquals("Seleziona i gruppi in cui aggiungere l’utente", titleAddGroup);

        UserCreatePO userCreatePO1 = userAddToGroupPO.confirm();

        String titleNewUserAdd = userCreatePO1.getTitle();
        assertEquals("Nuovo utente", titleNewUserAdd);

        UsersAndGroupsPO usersAndGroupsPO1 = userCreatePO1.confirm();

        String titleUsersAndGroupsDetail = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsDetail);
    }

    /**
     * Test azione di apertura tab dei gruppi e ritorno alla pagina precedente.
     */
    @Test
    public void groupsTabAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        UsersAndGroupsPO usersAndGroupsPO1 = groupsPO.back();

        String titleUsersAndGroupsBack = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsBack);
    }

    /**
     * Test azione apertura dettaglio gruppo e ritorno alla pagina precedente.
     */
    @Test
    public void groupDetailAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        GroupDetailPO groupDetailPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = groupDetailPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);

        GroupsPO groupsPO1 = groupDetailPO.back();

        String groupNameBack = groupsPO1.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupNameBack);
    }

    /**
     * Test azione di apertura modifica gruppo e ritorno alla pagina precedente.
     */
    @Test
    public void groupEditAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        GroupDetailPO groupDetailPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = groupDetailPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);

        GroupEditPO groupEditPO = groupDetailPO.edit();

        String groupEditTitle = groupEditPO.getTitle();
        assertEquals("Dettaglio gruppo", groupEditTitle);

        GroupsPO groupsPO1 = groupEditPO.save();

        String groupNameEdit = groupsPO1.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupNameEdit);
    }

    /**
     * Test azione di apertura creazione gruppo e ritorno alla pagina precedente.
     */
    @Test
    public void groupCreateAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        GroupCreatePO groupCreatePO = groupsPO.create();

        String titleGroupDetail = groupCreatePO.getTitle();
        assertEquals("Nuovo gruppo", titleGroupDetail);

        GroupAddUserPO groupAddUserPO = groupCreatePO.add();

        String titleAddUser = groupAddUserPO.getTitle();
        assertEquals("Seleziona gli utenti da aggiungere al gruppo", titleAddUser);

        GroupCreatePO groupCreatePO1 = groupAddUserPO.confirm();

        String titleGroupDetailAdd = groupCreatePO1.getTitle();
        assertEquals("Nuovo gruppo", titleGroupDetailAdd);

        GroupsPO groupsPO1 = groupCreatePO.cancel();

        String groupNameBack = groupsPO1.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupNameBack);
    }

    // ------------------------------------------------------------------------------------
    // TEST UTENTE TIPOLOGIA STANDARD
    // ------------------------------------------------------------------------------------

    /**
     * Test azione di visualizzazione dettaglio comunicazione e di ritorno alla pagina precedente.
     */
    @Test
    public void communicationDetailBreadCrumbStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di creazione comunicazione e selezione utenti e ritorno alla pagina precedente.
     */
    @Test
    public void communicationCreateStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        CommunicationCreatePO communicationCreatePO = communicationPO.create();

        String titleCreateCommunication = communicationCreatePO.getTitle();
        assertEquals("Nuova comunicazione", titleCreateCommunication);

        CommunicationSelectUserPO communicationSelectUserPO = communicationCreatePO.select();

        String titleSelectUser = communicationSelectUserPO.getTitle();
        assertEquals("Seleziona gli utenti destinatari della comunicazione", titleSelectUser);

        CommunicationCreatePO communicationCreatePO1 = communicationSelectUserPO.confirm();

        String titleDetailCommunicationSelect = communicationCreatePO1.getTitle();
        assertEquals("Nuova comunicazione", titleDetailCommunicationSelect);

        CommunicationPO communicationPO1 = communicationCreatePO1.cancel();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di apertura chat nel dettaglio comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void chatCommunicationStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        ChatPO chatPO = communicationDetailPO.openChat();

        String titleChat = chatPO.getTitle();
        assertEquals("Chat con ABI 08016", titleChat);

        CommunicationDetailPO communicationDetailPO1 = chatPO.closeChat();

        String titleDetailCommunicationFromChat = communicationDetailPO1.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunicationFromChat);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione apertura configurazione e ritorno alla pagina precedente.
     */
    @Test
    public void configurationStandardTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        CommunicationPO communicationPO1 = configurationPO.clickCommunication();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione apertura modifica di una comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void acknowledgmentEditStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

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

    /**
     * Test azione di apertura tab Notifiche e ritorno alla pagina precedente.
     */
    @Test
    public void notificationTabStandardTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        ConfigurationPO configurationPO1 = notificationPO.backToCommunication();

        String titleCommunicationBack = configurationPO1.getTitle();
        assertEquals("Configurazione", titleCommunicationBack);
    }

    /**
     * Test azione apertura dettaglio notifica e ritorno alla pagina precedente.
     */
    @Test
    public void notificationDetailStandardTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationDetailPO notificationDetailPO = notificationPO.clickDetail();

        String titleNotificationDetail = notificationDetailPO.getTitle();
        assertEquals("[Descrizione notifica]", titleNotificationDetail);

        NotificationPO notificationPO1 = notificationDetailPO.back();

        String titleNotificationBack = notificationPO1.getTitle();
        assertEquals("Notifiche", titleNotificationBack);
    }

    /**
     * Test azione apertura modifica notifica e ritorno alla pagina precedente.
     */
    @Test
    public void notificationEditStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

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

    /**
     * Test azione di apertura creazione notifica e ritorno alla pagina precedente.
     */
    @Test
    public void notificationCreateStandardTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

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

    /**
     * Test azione apertura tab dei testi e ritono alla pagina precedente.
     */
    @Test
    public void textTabStandardTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);

        ConfigurationPO configurationPO1 = textPO.back();

        String titleConfigurationBack = configurationPO1.getTitle();
        assertEquals("Configurazione", titleConfigurationBack);
    }

    /**
     * Test azione di apertura modifica testo e ritorno alla pagina precedente.
     */
    @Test
    public void textEditStandardTest()  {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);

        TextEditPO textEditPO = textPO.edit();

        String saveButtonText = textEditPO.getSaveButtonText();
        assertEquals("SALVA", saveButtonText);

        TextPO textPO1 = textEditPO.save();

        String firstTextSave = textPO1.getFirstText();
        assertEquals("Alert normativo", firstTextSave);
    }

    /**
     * Test azione di apertura tab delle firme e ritorno alla pagina precedente.
     */
    @Test
    public void signatureTabStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);

        ConfigurationPO configurationPO1 = signaturePO.back();

        String titleConfigurationBack = configurationPO1.getTitle();
        assertEquals("Configurazione", titleConfigurationBack);
    }

    /**
     * Test azione di apertura pagina di modifica firma e ritorno alla pagina precedente.
     */
    @Test
    public void signatureEditStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);

        SignatureEditPO signatureEditPO = signaturePO.edit();

        String saveButtonText = signatureEditPO.getSaveButtonText();
        assertEquals("SALVA", saveButtonText);

        SignaturePO signaturePO1 = signatureEditPO.save();

        String firstSignatureSave = signaturePO1.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignatureSave);
    }

    /**
     * Test azione di apertura creazione firma e ritorno alla pagina precedente.
     */
    @Test
    public void signatureCreateStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);

        SignatureCreatePO signatureCreatePO = signaturePO.create();

        String saveButtonText = signatureCreatePO.getTitle();
        assertEquals("Crea nuova firma", saveButtonText);

        SignaturePO signaturePO1 = signatureCreatePO.save();

        String firstSignatureSave = signaturePO1.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignatureSave);
    }

    /**
     * Test azione di apertura dettaglio utente e ritorno alla pagina precedente.
     */
    @Test
    public void UserDetailBreadCrumbStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserDetailPO userDetailPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = userDetailPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);

        UsersAndGroupsPO usersAndGroupsPO1 = userDetailPO.backBreadCrumb();

        String titleUsersAndGroupsDetail = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsDetail);
    }

    /**
     * Test azione di apertura dettaglio utente e ritorno alla pagina precedente tramite side bar.
     */
    @Test
    public void UserDetailSideMenuStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserDetailPO userDetailPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = userDetailPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);

        UsersAndGroupsPO usersAndGroupsPO1 = userDetailPO.back();

        String titleUsersAndGroupsDetail = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsDetail);
    }

    /**
     * Test azione di apertura modifica utente e ritorno alla pagina precedente.
     */
    @Test
    public void UserEditStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserDetailPO userDetailPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = userDetailPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);

        UserEditPO userEditPO = userDetailPO.edit();

        String titleUserEdit = userEditPO.getTitle();
        assertEquals("Dettaglio utente", titleUserEdit);

        UsersAndGroupsPO usersAndGroupsPO1 = userEditPO.save();

        String titleUserDetailEdit = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUserDetailEdit);
    }

    /**
     * Test azione di apertura creazione utente e ritorno alla pagina precedente.
     */
    @Test
    public void UserCreateStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        UserCreatePO userCreatePO = usersAndGroupsPO.create();

        String titleNewUser = userCreatePO.getTitle();
        assertEquals("Nuovo utente", titleNewUser);

        UserAddToGroupPO userAddToGroupPO = userCreatePO.add();

        String titleAddGroup = userAddToGroupPO.getTitle();
        assertEquals("Seleziona i gruppi in cui aggiungere l’utente", titleAddGroup);

        UserCreatePO userCreatePO1 = userAddToGroupPO.confirm();

        String titleNewUserAdd = userCreatePO1.getTitle();
        assertEquals("Nuovo utente", titleNewUserAdd);

        UsersAndGroupsPO usersAndGroupsPO1 = userCreatePO1.confirm();

        String titleUsersAndGroupsDetail = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsDetail);
    }

    /**
     * Test azione di apertura tab dei gruppi e ritorno alla pagina precedente.
     */
    @Test
    public void groupsTabStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        UsersAndGroupsPO usersAndGroupsPO1 = groupsPO.back();

        String titleUsersAndGroupsBack = usersAndGroupsPO1.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroupsBack);
    }

    /**
     * Test azione apertura dettaglio gruppo e ritorno alla pagina precedente.
     */
    @Test
    public void groupDetailStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        GroupDetailPO groupDetailPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = groupDetailPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);

        GroupsPO groupsPO1 = groupDetailPO.back();

        String groupNameBack = groupsPO1.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupNameBack);
    }

    /**
     * Test azione di apertura modifica gruppo e ritorno alla pagina precedente.
     */
    @Test
    public void groupEditStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        GroupDetailPO groupDetailPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = groupDetailPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);

        GroupEditPO groupEditPO = groupDetailPO.edit();

        String groupEditTitle = groupEditPO.getTitle();
        assertEquals("Dettaglio gruppo", groupEditTitle);

        GroupsPO groupsPO1 = groupEditPO.save();

        String groupNameEdit = groupsPO1.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupNameEdit);
    }

    /**
     * Test azione di apertura creazione gruppo e ritorno alla pagina precedente.
     */
    @Test
    public void groupCreateStandardTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.STANDARD);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        GroupCreatePO groupCreatePO = groupsPO.create();

        String titleGroupDetail = groupCreatePO.getTitle();
        assertEquals("Nuovo gruppo", titleGroupDetail);

        GroupAddUserPO groupAddUserPO = groupCreatePO.add();

        String titleAddUser = groupAddUserPO.getTitle();
        assertEquals("Seleziona gli utenti da aggiungere al gruppo", titleAddUser);

        GroupCreatePO groupCreatePO1 = groupAddUserPO.confirm();

        String titleGroupDetailAdd = groupCreatePO1.getTitle();
        assertEquals("Nuovo gruppo", titleGroupDetailAdd);

        GroupsPO groupsPO1 = groupCreatePO.cancel();

        String groupNameBack = groupsPO1.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupNameBack);
    }

    // ------------------------------------------------------------------------------------
    // TEST UTENTE TIPOLOGIA BANCA
    // ------------------------------------------------------------------------------------

    /**
     * Test azione di apertura dettaglio comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void communicationDetailBreadCrumbBankTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.BANK);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione apertura dettaglio e ritorno alal pagina precedente tramite side bar.
     */
    @Test
    public void communicationDetailSideMenuBankTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.BANK);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationPO communicationPO1 = communicationDetailPO.back();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di apertura inoltro comunicazione e selezione contatti e ritorno alla pagina precedente.
     */
    @Test
    public void communicationForwardBankTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.BANK);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationForwardPO communicationForwardPO = communicationDetailPO.forward();

        String titleForward = communicationForwardPO.getTitle();
        assertEquals("Inoltra comunicazione 34893549085", titleForward);

        CommunicationSelectContactPO communicationSelectContactPO = communicationForwardPO.select();

        String titleSelectContact = communicationSelectContactPO.getTitle();
        assertEquals("Seleziona i contatti a cui inoltrare la comunicazione", titleSelectContact);

        CommunicationForwardPO communicationForwardPO1 = communicationSelectContactPO.confirm();

        String titleForwardSelect = communicationForwardPO.getTitle();
        assertEquals("Inoltra comunicazione 34893549085", titleForwardSelect);

        CommunicationDetailPO communicationDetailPO1 = communicationForwardPO1.cancel();

        String titleDetailCommunicationForward = communicationDetailPO1.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunicationForward);
    }

    /**
     * Test azione di apertura risposta comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void communicationAnswerBankTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.BANK);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunication);

        CommunicationAnswerPO communicationAnswerPO = communicationDetailPO.answer();

        String titleAnswer = communicationAnswerPO.getTitle();
        assertEquals("Chat", titleAnswer);

        CommunicationDetailPO communicationDetailPO1 = communicationAnswerPO.back();

        String titleDetailCommunicationForward = communicationDetailPO1.getTitle();
        assertEquals("[Nome comunicazione]", titleDetailCommunicationForward);
    }

    /**
     * Test azione apertura modifica rubrica e ritorno alla pagina precedente.
     */
    @Test
    public void addressBookEditBankTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.BANK);

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

    /**
     * Test azione di apertura creazione contatto e ritorno alla pagina precedente.
     */
    @Test
    public void addressBookCreateBankTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.BANK);

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
