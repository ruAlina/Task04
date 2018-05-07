package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePageObject {

    @FindBy(xpath = "//ul[contains(@class,'alt-menu-mid')]")
    public WebElement mainMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem) {
        click(mainMenu.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]")));
    }

    public void selectSubMenu(String menuItem) {
        click(mainMenu.findElement(By.xpath(".//A[text()='" + menuItem + "']")));
    }
}
