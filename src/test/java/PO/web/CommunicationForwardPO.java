package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationForwardPO extends PageObject {

    @FindBy(xpath = "//div[contains(text(), 'Inoltra comunicazione')]")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'ANNULLA')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[contains(text(), 'SELEZIONA')]")
    private WebElement selectButton;

    private final WebDriverWait wait;

    public CommunicationForwardPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        driver.manage().window().maximize();

        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Inoltra comunicazione 13/2024 Prova banca affilitata CC9016"));

        return this.title.getText();
    }

    public CommunicationDetailPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new CommunicationDetailPO(driver);
    }

    public CommunicationSelectContactPO select() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.selectButton));

        this.selectButton.click();
        return new CommunicationSelectContactPO(driver);
    }
}

