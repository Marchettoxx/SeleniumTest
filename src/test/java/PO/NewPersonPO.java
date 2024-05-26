package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPersonPO extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(name = "firstname")
    private WebElement formName;

    @FindBy(name = "lastname")
    private WebElement formLastName;

    public NewPersonPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public ListPO submit(String name, String lastname) {
        this.formName.sendKeys(name);
        this.formLastName.sendKeys(lastname);
        this.formLastName.submit();
        return new ListPO(driver);
    }
}
