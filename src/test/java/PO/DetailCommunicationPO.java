package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailCommunicationPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Nome comunicazione]']")
    private WebElement title;

    @FindBy(linkText = "Comunicazioni")
    private WebElement communicationLinkBreadCrumb;

    public DetailCommunicationPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public CommunicationPO returnBackBreadCrumb() {
        this.communicationLinkBreadCrumb.click();
        return new CommunicationPO(driver);
    }
}

