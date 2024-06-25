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

    public HomePO(WebDriver driver) {
        super(driver);
    }

    public CommunicationPO goToCommunicationPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(this.dropDownMenuButton));
        this.dropDownMenuButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(this.manageCommunicationButton));
        this.manageCommunicationButton.click();

        return new CommunicationPO(driver);
    }
}

