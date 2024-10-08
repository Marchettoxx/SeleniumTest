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
        chrome_options.addArguments("--headless=new");
        chrome_options.addArguments("--disable-search-engine-choice-screen");
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
     * Test azione di creazione comunicazione e selezione utenti e ritorno alla pagina precedente.
     */
    @Test
    public void communicationCreateBreadCrumbAdminTest() {
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

        CommunicationPO communicationPO1 = communicationCreatePO1.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di creazione comunicazione e selezione utenti e ritorno alla pagina precedente.
     */
    @Test
    public void communicationCreateSideMenuAdminTest() {
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

        CommunicationPO communicationPO1 = communicationCreatePO1.back();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di apertura chat nel dettaglio comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void chatCommunicationBreadCrumbAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("2/2024 Test chat", titleDetailCommunication);

        ChatPO chatPO = communicationDetailPO.openChat();

        String titleChat = chatPO.getTitle();
        assertEquals("Chat con ABI 05662", titleChat);

        CommunicationDetailPO communicationDetailPO1 = chatPO.closeChat();

        String titleDetailCommunicationFromChat = communicationDetailPO1.getTitle();
        assertEquals("2/2024 Test chat", titleDetailCommunicationFromChat);

        CommunicationPO communicationPO1 = communicationDetailPO.returnBackBreadCrumb();

        String titleCommunicationBack = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunicationBack);
    }

    /**
     * Test azione di apertura chat nel dettaglio comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void chatCommunicationSideMenuAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetail();

        String titleDetailCommunication = communicationDetailPO.getTitle();
        assertEquals("2/2024 Test chat", titleDetailCommunication);

        ChatPO chatPO = communicationDetailPO.openChat();

        String titleChat = chatPO.getTitle();
        assertEquals("Chat con ABI 05662", titleChat);

        CommunicationDetailPO communicationDetailPO1 = chatPO.closeChat();

        String titleDetailCommunicationFromChat = communicationDetailPO1.getTitle();
        assertEquals("2/2024 Test chat", titleDetailCommunicationFromChat);

        CommunicationPO communicationPO1 = communicationDetailPO.back();

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

        String buttonSaveText = acknowledgeEditPO.getCancelButtonText();
        assertEquals("ANNULLA", buttonSaveText);

        ConfigurationPO configurationPO1 = acknowledgeEditPO.clickCancel();

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
    public void notificationDetailAdminTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);

        NotificationDetailPO notificationDetailPO = notificationPO.clickDetail();

        String titleNotificationDetail = notificationDetailPO.getTitle();
        assertEquals("Regola di notifica 2", titleNotificationDetail);

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
        assertEquals("Regola di notifica 2", titleNotificationDetail);

        NotificationEditPO notificationEditPO = notificationDetailPO.edit();

        String titleDetail = notificationEditPO.getTitle();
        assertEquals("Dettaglio notifica", titleDetail);

        NotificationDetailPO notificationDetailPO1 = notificationEditPO.cancel();

        String titleNotificationDetailSave = notificationDetailPO1.getTitle();
        assertEquals("Regola di notifica 2", titleNotificationDetailSave);

        NotificationPO notificationPO1 = notificationDetailPO1.back();

        String titleNotificationBack = notificationPO1.getTitle();
        assertEquals("Notifiche", titleNotificationBack);
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

        String title = notificationCreatePO.getTitle();
        assertEquals("Nuova notifica", title);

        NotificationPO notificationPO1 = notificationCreatePO.cancel();

        String titleNotificationBack = notificationPO1.getTitle();
        assertEquals("Notifiche", titleNotificationBack);
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

        SignaturePO signaturePO1 = signatureCreatePO.cancel();

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
        assertEquals("WORKFLOW test", titleUserDetail);

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
        assertEquals("WORKFLOW test", titleUserDetail);

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
        assertEquals("WORKFLOW test", titleUserDetail);

        UserEditPO userEditPO = userDetailPO.edit();

        String titleUserEdit = userEditPO.getTitle();
        assertEquals("Dettaglio utente", titleUserEdit);

        UserDetailPO userDetailPO1 = userEditPO.cancel();

        String titleUserDetailEdit = userDetailPO1.getTitle();
        assertEquals("WORKFLOW test", titleUserDetailEdit);
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

        UserCreatePO userCreatePO1 = userAddToGroupPO.close();

        String titleNewUserAdd = userCreatePO1.getTitle();
        assertEquals("Nuovo utente", titleNewUserAdd);

        UsersAndGroupsPO usersAndGroupsPO1 = userCreatePO1.cancel();

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
        assertEquals("Test", groupName);

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
        assertEquals("Test", groupName);

        GroupDetailPO groupDetailPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = groupDetailPO.getTitle();
        assertEquals("Test", titleGroupDetail);

        GroupsPO groupsPO1 = groupDetailPO.back();

        String groupsPO1GroupText = groupsPO1.getGroupText();
        assertEquals("Test", groupsPO1GroupText);
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
        assertEquals("Test", groupName);

        GroupDetailPO groupDetailPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = groupDetailPO.getTitle();
        assertEquals("Test", titleGroupDetail);

        GroupEditPO groupEditPO = groupDetailPO.edit();

        String groupEditTitle = groupEditPO.getTitle();
        assertEquals("Dettaglio gruppo", groupEditTitle);

        GroupDetailPO groupDetailPO1 = groupEditPO.cancel();

        String groupDetailPO1Title = groupDetailPO1.getTitle();
        assertEquals("Test", groupDetailPO1Title);
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
        assertEquals("Test", groupName);

        GroupCreatePO groupCreatePO = groupsPO.create();

        String titleGroupDetail = groupCreatePO.getTitle();
        assertEquals("Nuovo gruppo", titleGroupDetail);

        GroupAddUserPO groupAddUserPO = groupCreatePO.add();

        String titleAddUser = groupAddUserPO.getTitle();
        assertEquals("Seleziona gli utenti da aggiungere al gruppo", titleAddUser);

        GroupCreatePO groupCreatePO1 = groupAddUserPO.close();

        String titleGroupDetailAdd = groupCreatePO1.getTitle();
        assertEquals("Nuovo gruppo", titleGroupDetailAdd);

        GroupsPO usersAndGroupsPO1 = groupCreatePO.cancel();

        String titleUsersAndGroupsBack = usersAndGroupsPO1.getGroupText();
        assertEquals("Test", titleUsersAndGroupsBack);
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

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetailBase();

        String titleDetailCommunication = communicationDetailPO.getTitleBase();
        assertEquals("13/2024 Prova banca affilitata CC9016", titleDetailCommunication);

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

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetailBase();

        String titleDetailCommunication = communicationDetailPO.getTitleBase();
        assertEquals("13/2024 Prova banca affilitata CC9016", titleDetailCommunication);

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

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetailBase();

        String titleDetailCommunication = communicationDetailPO.getTitleBase();
        assertEquals("13/2024 Prova banca affilitata CC9016", titleDetailCommunication);

        CommunicationForwardPO communicationForwardPO = communicationDetailPO.forward();

        String titleForward = communicationForwardPO.getTitle();
        assertEquals("Inoltra comunicazione 13/2024 Prova banca affilitata CC9016", titleForward);

        CommunicationSelectContactPO communicationSelectContactPO = communicationForwardPO.select();

        String titleSelectContact = communicationSelectContactPO.getTitle();
        assertEquals("Seleziona i contatti a cui inoltrare la comunicazione", titleSelectContact);

        CommunicationForwardPO communicationForwardPO1 = communicationSelectContactPO.close();

        String titleForwardSelect = communicationForwardPO.getTitle();
        assertEquals("Inoltra comunicazione 13/2024 Prova banca affilitata CC9016", titleForwardSelect);

        CommunicationDetailPO communicationDetailPO1 = communicationForwardPO1.cancel();

        String titleDetailCommunicationForward = communicationDetailPO1.getTitleBase();
        assertEquals("13/2024 Prova banca affilitata CC9016", titleDetailCommunicationForward);
    }

    /**
     * Test azione di apertura risposta comunicazione e ritorno alla pagina precedente.
     */
    @Test
    public void communicationAnswerBankTest() {
        CommunicationPO communicationPO = this.login(UserTypeEnum.BANK);

        CommunicationDetailPO communicationDetailPO = communicationPO.clickDetailBase();

        String titleDetailCommunication = communicationDetailPO.getTitleBase();
        assertEquals("13/2024 Prova banca affilitata CC9016", titleDetailCommunication);

        CommunicationAnswerPO communicationAnswerPO = communicationDetailPO.answer();

        String titleAnswer = communicationAnswerPO.getTitle();
        assertEquals("Chat", titleAnswer);

        CommunicationDetailPO communicationDetailPO1 = communicationAnswerPO.back();

        String titleDetailCommunicationForward = communicationDetailPO1.getTitleBase();
        assertEquals("13/2024 Prova banca affilitata CC9016", titleDetailCommunicationForward);
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

        AddressBookPO addressBookPO1 = addressBookCreatePO.cancel();

        String titleAddressBookEdit = addressBookPO1.getTitle();
        assertEquals("Rubrica", titleAddressBookEdit);
    }
}