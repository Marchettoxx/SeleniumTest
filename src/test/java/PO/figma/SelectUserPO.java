package PO.figma;

import model.UserTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectUserPO extends PageObject {

    @FindBy(xpath = "//a[text()='UTENTE AMMINISTRATIVO']")
    private WebElement adminButton;

    @FindBy(xpath = "//a[text()='UTENTE STANDARD']")
    private WebElement standardButton;

    @FindBy(xpath = "//a[text()='UTENTE BANCA']")
    private WebElement bankButton;

    private final WebDriverWait wait;

    public SelectUserPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public CommunicationPO selectUserType(UserTypeEnum userTypeEnum) {
        WebElement choice = null;
        switch (userTypeEnum) {
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

        this.wait.until(ExpectedConditions.elementToBeClickable(choice));
        choice.click();
        return new CommunicationPO(driver);
    }
}

