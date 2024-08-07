package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupAddUserPO extends PageObject {

    @FindBy(xpath = "//span[text()='Seleziona gli utenti da aggiungere al gruppo']")
    private WebElement title;

    @FindBy(xpath = "//a[@href='/cmcreanuovogruppo']")
    private WebElement closeButton;

    private final WebDriverWait wait;

    public GroupAddUserPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Seleziona gli utenti da aggiungere al gruppo"));

        return this.title.getText();
    }

    public GroupCreatePO close() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.closeButton));

        this.closeButton.click();
        return new GroupCreatePO(driver);
    }
}

