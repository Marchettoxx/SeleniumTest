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

    @FindBy(xpath = "//input[@value='Avanti']")
    private WebElement submitUsernameButton;

    @FindBy(xpath = "//input[@value='Verifica']")
    private WebElement submitPasswordButton;

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public HomePO login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Attendi che l'input dell'username diventi cliccabile e poi inserisci il valore
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput)).sendKeys(username);

        // Attendi che il pulsante di submit per l'username diventi cliccabile e poi clicca
        wait.until(ExpectedConditions.elementToBeClickable(submitUsernameButton)).click();

        // Attendi che l'input della password diventi visibile e poi inserisci il valore
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);

        // Attendi che il pulsante di submit per la password diventi cliccabile e poi clicca
        wait.until(ExpectedConditions.elementToBeClickable(submitPasswordButton)).click();

        // Ritorna un nuovo oggetto HomePO dopo il login
        return new HomePO(driver);
    }
}

