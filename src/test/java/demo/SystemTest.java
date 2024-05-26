package demo;

import PO.EditPersonPO;
import PO.ListPO;
import PO.NewPersonPO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.lang3.SystemUtils;

import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SystemTest {

    private WebDriver driver;
    @Before
    public void setUp() {
        org.openqa.selenium.chrome.ChromeOptions chrome_options = new ChromeOptions();
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
    public void testA() {
        driver.get("http://localhost:8080");
        String title1 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("People list", title1);
        WebElement res = driver.findElement(By.linkText("Add new person"));
        res.click();

        String title2 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Create a new record", title2);
        driver.findElement(By.name("firstname")).sendKeys("Marco");
        driver.findElement(By.name("lastname")).sendKeys("Massagrande");
        driver.findElement(By.name("firstname")).submit();

        String title3 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("People list", title3);
        WebElement tab = driver.findElement(By.tagName("table"));
        List<WebElement> webElements = tab.findElements(By.tagName("tr"));
        assertEquals(2, webElements.size());

        WebElement val = driver.findElement(By.xpath("//table//tbody//td[2]"));
        assertEquals("Marco", val.getText());

        WebElement edit = driver.findElement(By.xpath("//table//tbody//td[5]"));
        edit.click();
        String title4 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Edit a record", title4);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("Massapiccolo");
        driver.findElement(By.name("lastname")).submit();

        String title5 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("People list", title5);

        WebElement valChanged = driver.findElement(By.xpath("//table//tbody//td[3]"));
        assertEquals("Massapiccolo", valChanged.getText());

        WebElement delete = driver.findElement(By.xpath("//table//tbody//td[6]"));
        delete.click();

        WebElement tabChanged = driver.findElement(By.tagName("table"));
        List<WebElement> webElements2 = tabChanged.findElements(By.tagName("tr"));
        assertEquals(1, webElements2.size());
    }

    @Test
    public void testAPO() {
        driver.get("http://localhost:8080");
        ListPO listPO = new ListPO(driver);
        String title1 = listPO.getTitle();
        assertEquals("People list", title1);
        NewPersonPO res = listPO.clickAdd();

        String title2 = res.getTitle();
        assertEquals("Create a new record", title2);
        ListPO res2 = res.submit("Marco", "Massagrande");

        String title3 = res2.getTitle();
        assertEquals("People list", title3);
        assertEquals(2, res2.getNumRows());

        assertEquals("Marco", res2.getValRow(2));

        EditPersonPO editPersonPO = res2.editPerson();
        String title4 = editPersonPO.getTitle();
        assertEquals("Edit a record", title4);
        ListPO res3 = editPersonPO.change(java.util.Optional.<String>empty(), Optional.of("Massapiccolo"));

        String title5 = res3.getTitle();
        assertEquals("People list", title5);

        assertEquals("Massapiccolo", res3.getValRow(3));

        ListPO res4 = res3.deletePerson();

        assertEquals(1, res4.getNumRows());
    }
}
