package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextPO extends PageObject {

    @FindBy(xpath = "//span[text()='Alert normativo']")
    private WebElement firstText;

    @FindBy(linkText = "Presa visione")
    private WebElement ackTab;

    @FindBy(linkText = "Modifica")
    private WebElement editButton;

    public TextPO(WebDriver driver) {
        super(driver);
    }

    public String getFirstText() {
        return this.firstText.getText();
    }

    public TextEditPO edit() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new TextEditPO(driver);
    }

    public ConfigurationPO back() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.ackTab));

        this.ackTab.click();
        return new ConfigurationPO(driver);
    }
}

