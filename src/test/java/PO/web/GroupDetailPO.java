package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupDetailPO extends PageObject {

    @FindBy(xpath = "//div[text()='Test']")
    private WebElement title;

    @FindBy(xpath = "//span[contains(@class, 'k-breadcrumb-item-text') and text()='Utenti e Gruppi']")
    private WebElement backLink;
    @FindBy(xpath = "//span[contains(text(), 'MODIFICA')]")
    private WebElement editButton;

    private final WebDriverWait wait;

    public GroupDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        driver.manage().window().maximize();

        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Test"));
        
        return this.title.getText();
    }

    public GroupsPO back() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.backLink));

        this.backLink.click();
        return new GroupsPO(driver);
    }

    public GroupEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new GroupEditPO(driver);
    }
}

