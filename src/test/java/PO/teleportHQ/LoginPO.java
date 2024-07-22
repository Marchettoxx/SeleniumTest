package PO.teleportHQ;

import PO.utility.SelectUserPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPO extends PageObject {

    private static final Logger LOGGER = Logger.getLogger(LoginPO.class.getName());

    @FindBy(name = "_vercel_password")
    private WebElement passwordInput;

    @FindBy(className = "submit")
    private WebElement submitButton;

    private final WebDriverWait wait;

    public LoginPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public SelectUserPO login(String password) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(this.passwordInput));
            passwordInput.sendKeys(password);

            this.wait.until(ExpectedConditions.elementToBeClickable(this.submitButton));
            submitButton.click();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred during login", e);
        }

        return new SelectUserPO(driver);
    }
}

