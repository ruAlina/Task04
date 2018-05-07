package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.Set;

public class BasePageObject {

    protected WebDriver driver = BaseSteps.getDriver();

    public void click(WebElement element) {
        click(ExpectedConditions.elementToBeClickable(element));
    }

    private void click(ExpectedCondition<WebElement> condition) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(condition).click();
    }

    public boolean switchTo(String titlePart) {
        String old = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (handle.equals(old))
                continue;
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(titlePart))
                return true;
        }
        driver.switchTo().window(old);
        return false;
    }
}
