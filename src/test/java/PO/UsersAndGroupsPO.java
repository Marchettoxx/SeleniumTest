package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersAndGroupsPO extends PageObject {

    @FindBy(xpath = "//span[text()='Utenti e gruppi']")
    private WebElement title;

    @FindBy(linkText = "laura.bianchini@cassacentrale.it")
    private WebElement detailLink;

    @FindBy(linkText = "Gestione gruppi")
    private WebElement groupsLink;

    public UsersAndGroupsPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public DetailUserPO clickDetailUser() {
        this.detailLink.click();
        return new DetailUserPO(driver);
    }

    public GroupsPO clickGroups() {
        this.groupsLink.click();
        return new GroupsPO(driver);
    }
}

