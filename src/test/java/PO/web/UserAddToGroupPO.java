package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAddToGroupPO extends PageObject {

    @FindBy(xpath = "//div[contains(text(), 'Seleziona i gruppi in cui aggiungere l’utente')]")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'CONFERMA')]")
    private WebElement confirmButton;

    private final WebDriverWait wait;

    public UserAddToGroupPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 20);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Seleziona i gruppi in cui aggiungere l’utente"));

        return this.title.getText();
    }

    public UserCreatePO confirm() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.confirmButton));

        this.confirmButton.click();
        return new UserCreatePO(driver);
    }
}

