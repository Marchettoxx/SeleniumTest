package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='Nuovo utente']")
    private WebElement title;

    @FindBy(linkText = "CONFERMA")
    private WebElement confirmButton;

    public UserCreatePO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public UsersAndGroupsPO confirm() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.confirmButton));

        this.confirmButton.click();
        return new UsersAndGroupsPO(driver);
    }
}

