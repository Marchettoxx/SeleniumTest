package demo;

import PO.*;
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

    public CommunicationPO login() {
        String url = "https://testselenium.teleporthq.app/";
        driver.get(url);
        driver.manage().window().maximize();

        LoginPO loginPO = new LoginPO(driver);
        String password = "ESGJ3P";

        return loginPO.login(password);
    }

    @Test
    public void ATest() {
        CommunicationPO communicationPO = this.login();

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);
    }

    @Test
    public void BTest() {
        CommunicationPO communicationPO = this.login();

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);
    }

    @Test
    public void CTest() {
        CommunicationPO communicationPO = this.login();

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        CommunicationPO communicationPO1 = configurationPO.clickCommunication();

        String titleCommunication = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunication);
    }

    @Test
    public void DTest() {
        CommunicationPO communicationPO = this.login();

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        NotificationPO notificationPO = configurationPO.clickNotification();

        String titleNotification = notificationPO.getTitle();
        assertEquals("Notifiche", titleNotification);
    }

    @Test
    public void ETest() {
        CommunicationPO communicationPO = this.login();

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        TextPO textPO = configurationPO.clickText();

        String firstText = textPO.getFirstText();
        assertEquals("Alert normativo", firstText);
    }

    @Test
    public void FTest() {
        CommunicationPO communicationPO = this.login();

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        SignaturePO textPO = configurationPO.clickSignature();

        String firstSignature = textPO.getFirstSignature();
        assertEquals("Firma CCB 1", firstSignature);
    }

    @Test
    public void GTest() {
        CommunicationPO communicationPO = this.login();

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);
    }

    @Test
    public void HTest() {
        CommunicationPO communicationPO = this.login();

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        DetailUserPO detailUserPO = usersAndGroupsPO.clickDetailUser();

        String titleUserDetail = detailUserPO.getTitle();
        assertEquals("[Cognome nome]", titleUserDetail);
    }

    @Test
    public void ITest() {
        CommunicationPO communicationPO = this.login();

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String newGroupButtonText = groupsPO.getNewGroupButtonText();
        assertEquals("NUOVO GRUPPO", newGroupButtonText);
    }

    @Test
    public void JTest() {
        CommunicationPO communicationPO = this.login();

        UsersAndGroupsPO usersAndGroupsPO = communicationPO.clickUsersAndGroups();

        String titleUsersAndGroups = usersAndGroupsPO.getTitle();
        assertEquals("Utenti e gruppi", titleUsersAndGroups);

        GroupsPO groupsPO = usersAndGroupsPO.clickGroups();

        String newGroupButtonText = groupsPO.getNewGroupButtonText();
        assertEquals("NUOVO GRUPPO", newGroupButtonText);

        DetailGroupPO detailGroupPO = groupsPO.clickDetailGroup();

        String titleGroupDetail = detailGroupPO.getTitle();
        assertEquals("[Nome gruppo]", titleGroupDetail);
    }
}
