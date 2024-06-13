package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommunicationPO extends PageObject {

    @FindBy(xpath = "//span[text()='Comunicazioni']")
    private WebElement title;

    @FindBy(linkText = "CONFIGURA")
    private WebElement configuraButton;

    @FindBy(linkText = "3/2024")
    private WebElement detailLink;

    public CommunicationPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public ConfigurationPO clickConfig() {
        this.configuraButton.click();
        return new ConfigurationPO(driver);
    }

    public DetailPO clickDetail() {
        this.detailLink.click();
        return new DetailPO(driver);
    }
}

