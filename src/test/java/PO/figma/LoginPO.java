package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends PageObject {

    @FindBy(name = "_vercel_password")
    private WebElement passwordInput;

    @FindBy(className = "submit")
    private WebElement submitButton;

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public SelectUserPO login(String password) {
        passwordInput.sendKeys(password);
        submitButton.click();
        return new SelectUserPO(driver);
    }
}

