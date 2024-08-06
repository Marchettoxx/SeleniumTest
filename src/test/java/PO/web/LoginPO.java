package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO extends PageObject {

    @FindBy(name = "identifier")
    private WebElement usernameInput;

    @FindBy(name = "credentials.passcode")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space(text())='Avanti']")
    private WebElement submitUsernameButton;

    @FindBy(xpath = "//button[normalize-space(text())='Verifica']")
    private WebElement submitPasswordButton;

    private final WebDriverWait wait;

    public LoginPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public HomePO login(String username, String password) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.usernameInput));
        this.usernameInput.sendKeys(username);

        this.wait.until(ExpectedConditions.elementToBeClickable(this.submitUsernameButton));
        this.submitUsernameButton.click();

        this.wait.until(ExpectedConditions.visibilityOf(this.passwordInput));
        this.passwordInput.sendKeys(password);

        this.wait.until(ExpectedConditions.elementToBeClickable(this.submitPasswordButton));
        this.submitPasswordButton.click();

        return new HomePO(driver);
    }
}

