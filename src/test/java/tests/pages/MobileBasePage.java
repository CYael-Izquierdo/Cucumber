package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public MobileBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Select Drop Menu Option
    public void selectDropMenuOption(By dropMenuBy, String option) {
        click(dropMenuBy);
        driver.findElement(dropMenuBy).findElement(By.linkText(option)).click();
    }

    public void selectDropMenuOption(By dropMenuBy, By option) {
        click(dropMenuBy);
        driver.findElement(dropMenuBy).findElement(option).click();
    }

}
