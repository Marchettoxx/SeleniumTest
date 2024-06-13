package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextPO extends PageObject {

    // Elemento del titolo "Alert normativo"
    @FindBy(xpath = "//span[text()='Alert normativo']")
    private WebElement firstText;

    public TextPO(WebDriver driver) {
        super(driver);
    }

    public String getFirstText() {
        return this.firstText.getText();
    }
}

