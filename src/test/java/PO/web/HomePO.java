package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePO extends PageObject {

    @FindBy(css = "kendo-button.bb-button")
    private WebElement dropDownMenuButton;

    @FindBy(css = "div.singleMenuItemContent span.item-info")
    private WebElement manageCommunicationButton;

    private final WebDriverWait wait;

    public HomePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    public CommunicationPO goToCommunicationPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.dropDownMenuButton));
        this.dropDownMenuButton.click();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.manageCommunicationButton));
        this.manageCommunicationButton.click();

        return new CommunicationPO(driver);
    }
}

