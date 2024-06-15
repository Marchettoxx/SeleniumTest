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

    @Test
    public void ATest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);
    }

    @Test
    public void BTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);
    }

    @Test
    public void CTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        CommunicationPO communicationPO1 = configurationPO.clickCommunication();

        String titleCommunication = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunication);
    }

    @Test
    public void DTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);
    }

    @Test
    public void ETest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);
    }

    @Test
    public void FTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO signaturePO = configurationPO.clickSignature();

        Thread.sleep(1000);
        String firstSignature = signaturePO.getFirstSignatureText();
        assertEquals("Firma CCB 1", firstSignature);
    }

    @Test
    public void GTest()  {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);
    }

    @Test
    public void HTest() {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        DetailUserPO detailUserPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = detailUserPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);
    }

    @Test
    public void ITest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        Thread.sleep(1000);
        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);
    }

    @Test
    public void JTest() throws InterruptedException {
        CommunicationPO communicationPO = this.login(UserType.ADMIN);

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        Thread.sleep(2000);
        String groupName = groupsPO.getGroupText();
        assertEquals("Gruppo Compliance 231 (ristretto)", groupName);

        DetailGroupPO detailGroupPO = groupsPO.clickDetailGroup();

        Thread.sleep(2000);
        String titleGroupDetail = detailGroupPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);
    }
}
