package PO;

import jdk.nashorn.internal.objects.annotations.Getter;
import model.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public CommunicationPO selectUserType(UserType userType) throws InterruptedException {
        switch (userType) {
            case ADMIN:
                this.adminButton.click();
                break;
            case STANDARD:
                this.standardButton.click();
                break;
            case BANK:
                this.bankButton.click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + userType);
        }

        Thread.sleep(2000);
        return new CommunicationPO(driver);
    }
}

