package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListPO extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(linkText = "Add new person")
    private WebElement buttonAddPerson;

    @FindBy(tagName = "tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//table//tbody")
    private WebElement row;

    @FindBy(xpath = "//table//tbody//td[5]")
    private WebElement buttonEdit;

    @FindBy(xpath = "//table//tbody//td[6]")
    private WebElement buttonDelete;

    public ListPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public NewPersonPO clickAdd() {
        this.buttonAddPerson.click();
        return new NewPersonPO(driver);
    }

    public int getNumRows() {
        return this.rows.size();
    }

    public String getValRow(int pos) {
        return this.row.findElement(By.xpath("//td["+String.valueOf(pos)+ "]")).getText();
    }

    public EditPersonPO editPerson() {
        this.buttonEdit.click();
        return new EditPersonPO(driver);
    }

    public ListPO deletePerson() {
        this.buttonDelete.click();
        return new ListPO(driver);
    }
}

