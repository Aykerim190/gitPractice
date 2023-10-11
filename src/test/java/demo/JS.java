package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JS extends BaseTest {

    // DOM -> Document object model
    // интерфейсы selenium
    // 1. Webelement -> методы sendKeys(), click(), getText(),
    // 2. Webdriver -> get(), menage(), findElement(), работает с интерфейсом и также ищет элементы в хтм, а js напрямую с хтмл
    // 3. JS executor -> executeScript(),

    @Test
    void demo1() throws InterruptedException {

        driver.get("https://demoqa.com/text-box");

        JavascriptExecutor js = (JavascriptExecutor) driver; // вызываем JavascriptExecutor и передаем наш драйвер,т.е. хотим чтобы js управлял нашим драйвером, браузером

        js.executeScript("window.location='https://demoqa.com/text-box'"); // открыть сайт и вместо get() используем js команду window.location

        //открываем страницы через JavascriptExecutor т.к. работает напрямую с html

        WebElement fullName = driver.findElement(By.id("userName"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", fullName, "border: 2px solid red");
        fullName.sendKeys("Demo ker");

        Thread.sleep(5000);

        WebElement email = driver.findElement(By.id("userEmail"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", email, "border: 2px solid red");
        email.sendKeys("jassd@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", currentAddress, "border: 2px solid red");
        currentAddress.sendKeys("Berlin");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", permanentAddress, "border: 2px solid red");
        permanentAddress.sendKeys("Deli");


        WebElement submit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", submit, "border: 2px solid red");

        js.executeScript("arguments[0].click()",submit);

        Thread.sleep(8000);

    }
}