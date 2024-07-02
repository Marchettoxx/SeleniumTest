package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextPO extends PageObject {

    @FindBy(xpath = "//div[contains(text(), 'Alert normativo')]")
    private WebElement firstText;

    @FindBy(xpath = "//span[contains(text(), 'Presa visione')]")
    private WebElement ackTab;

    @FindBy(xpath = "//span[contains(text(), 'MODIFICA')]")
    private WebElement editButton;

    private final WebDriverWait wait;

    public TextPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getFirstText() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.firstText, "Alert normativo"));

        return this.firstText.getText();
    }

    public TextEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new TextEditPO(driver);
    }

    public ConfigurationPO back() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.ackTab));

        this.ackTab.click();
        return new ConfigurationPO(driver);
    }
}

