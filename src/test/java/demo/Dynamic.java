package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dynamic extends BaseTest1{

    @FindBy(id = "enableAfter")
    public WebElement enableAfter;

    @FindBy(xpath = "//button[@id='colorChange']")
    public WebElement colorChange;

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfter;

    @Test(priority = 1)
    public void clickclick() throws InterruptedException {
        driver.get("https://demoqa.com/dynamic-properties");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")))// знать штук 10 кондишинал
                .click();
        Thread.sleep(3000);
}
@Test(priority = 2)
    public void VisibleA() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(7) )
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")))
                .click();
        Thread.sleep(3000);

}}

//@Test(priority = 3)
//    public void color(){
//    Wait<WebDriverWait> wait = new FluentWait<>(driver)
//            .withTimeout(Duration.ofSeconds(5))
//            .pollingEvery(Duration.ofSeconds(1));
//    wait.until(ExpectedConditions.attributeToBe(By.id()));
//}
//
//}
