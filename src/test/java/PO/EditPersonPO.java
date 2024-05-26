package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

public class EditPersonPO extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(name = "firstname")
    private WebElement formName;

    @FindBy(name = "lastname")
    private WebElement formLastName;

    public EditPersonPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public ListPO change(Optional<String> name, Optional<String> lastname) {
        if (name.isPresent()) {
            this.formName.clear();
            this.formName.sendKeys(name.get());
        }
        if (lastname.isPresent()) {
            this.formLastName.clear();
            this.formLastName.sendKeys(lastname.get());
        }
        this.formLastName.submit();
        return new ListPO(driver);
    }
}
