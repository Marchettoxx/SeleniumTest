package PO.utility;

import PO.teleportHQ.CommunicationPO;
import PO.teleportHQ.PageObject;
import model.UserTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectUserPO extends PageObject {

    @FindBy(xpath = "//a[@href='/cmcommunicationslistadmin']//span[text()='UTENTE AMMINISTRATIVO']")
    private WebElement adminButton;

//    @FindBy(xpath = "//a[contains(text(), 'UTENTE AMMINISTRATIVO')]")
//    private WebElement adminButton;

//    @FindBy(xpath = "//a[contains(text(), 'UTENTE BANCA')]")
//    private WebElement bankButton;

    @FindBy(xpath = "//a[@href='/communicationslistuser']//span[text()='UTENTE BANCA']")
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
            case BANK:
                choice = this.bankButton;
                break;
        }

        this.wait.until(ExpectedConditions.elementToBeClickable(choice));
        choice.click();
        return new CommunicationPO(driver);
    }
}

