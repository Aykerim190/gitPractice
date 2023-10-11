package demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class BrowserWindows extends BaseTest{
    // переключение вкладок

    @Test
    public void windowsTest() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("tabButton")))
                .click(); // открывается новая вкладка
        Thread.sleep(5000);
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());//собирает вкладки
        System.out.println(tabs.get(1));
        driver.switchTo().window(tabs.get(0)); // переход на нулевую вкладку ,и с фреймами тоже switchto
        driver.switchTo().window(tabs.get(1));
        WebElement sample = driver.findElement(By.id("sampleHeading"));
        Thread.sleep(1000);
        Assert.assertEquals(sample.getText(), "This is a sample page");
        Thread.sleep(5000);
        driver.switchTo().window(tabs.get(0));

    }

    @Test
    public void windowsTest1() throws InterruptedException{
        driver.get("https://demoqa.com/browser-windows");
        String main = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("windowButton")))
                .click();
        String second = driver.getWindowHandle();
        Thread.sleep(1000);
driver.switchTo().window(main);
        Thread.sleep(1000);
        System.out.println(main);
        driver.switchTo().window(second);
        driver.switchTo().window(second);
        Thread.sleep(1000);

        WebElement sample = driver.findElement(By.id("sampleHeading"));
        Thread.sleep(1000);
        Assert.assertEquals(sample.getText(), "This is a sample page");
        Thread.sleep(1000);

    }

//    @Test
//    public void windowsTest2() throws InterruptedException{
//        driver.get("https://demoqa.com/browser-windows");
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.id("messageWindowButton")))
//                .click();
//        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());//собирает вкладки, можно в стринг сохранить как показано выше
//        System.out.println(tabs);
//        // переход на первую вкладку ,и с фреймами тоже switchto
//        driver.switchTo().window(tabs.get(1));
//        driver.manage().window().maximize();
//        WebElement sample = driver.findElement(By.xpath("/html/body"));
//
//        System.out.println(sample.getText());
//        Thread.sleep(1000);
//        Assert.assertTrue(sample.getText().contains("sharing"));// в хром не работает, работает на файрфокс
//    }


}
