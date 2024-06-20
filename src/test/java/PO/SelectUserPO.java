package PO;

import model.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectUserPO extends PageObject {

    @FindBy(linkText = "UTENTE AMMINISTRATIVO")
    private WebElement adminButton;

    @FindBy(linkText = "UTENTE STANDARD")
    private WebElement standardButton;

    @FindBy(linkText = "UTENTE BANCA")
    private WebElement bankButton;

    public SelectUserPO(WebDriver driver) {
        super(driver);
    }

    public CommunicationPO selectUserType(UserType userType) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement choice = null;
        switch (userType) {
            case ADMIN:
                choice = this.adminButton;
                break;
            case STANDARD:
                choice = this.standardButton;
                break;
            case BANK:
                choice = this.bankButton;
                break;
        }

        wait.until(ExpectedConditions.elementToBeClickable(choice));
        choice.click();
        return new CommunicationPO(driver);
    }
}

