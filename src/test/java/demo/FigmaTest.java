package demo;

import PO.*;
import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FigmaTest {

    private final String url = "https://testselenium.teleporthq.app/";
    private final String password = "ESGJ3P";
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
        if (driver == null)
            driver = new ChromeDriver(chrome_options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testA() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);

        LoginPO loginPO = new LoginPO(driver);
        CommunicationPO communicationPO = loginPO.login(this.password);

        String titleCommunication = communicationPO.getTitle();
        assertEquals("Comunicazioni", titleCommunication);

        ConfigurationPO configurationPO = communicationPO.clickConfig();

        String titleConfiguration = configurationPO.getTitle();
        assertEquals("Configurazione", titleConfiguration);

        CommunicationPO communicationPO1 = configurationPO.clickCommunication();

        titleCommunication = communicationPO1.getTitle();
        assertEquals("Comunicazioni", titleCommunication);
    }
}
