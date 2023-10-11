package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox extends BaseTest{

    @Test
    void fillUpTheFormTest() throws InterruptedException// zapolnit formu,для того,чтобы управлять браузером нужен драйвер
    {
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));

        String expectedFullName = "John Do";

        fullNameInputField.sendKeys(expectedFullName);

        WebElement emailField = driver.findElement(By.id("userEmail"));

        String expectedEmail = "john@gmail.com";

        emailField.sendKeys(expectedEmail);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

        String expectedCurrentAddress = "Bishkek";
        currentAddress.sendKeys(expectedCurrentAddress);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        String expectedPermanentAddress = "Berlin";
        permanentAddress.sendKeys(expectedPermanentAddress);

        WebElement submitBtn = driver.findElement(By.id("submit"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        submitBtn.click();

        Thread.sleep(5000);

        WebElement resultName = driver.findElement(By.id("name"));
        System.out.println(resultName.getText());
        Assert.assertTrue(resultName.getText().contains(expectedFullName));

        WebElement resultEmail = driver.findElement(By.id("email"));
        Assert.assertTrue(resultEmail.getText().contains(expectedEmail));

        WebElement resultCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        Assert.assertTrue(resultCurrentAddress.getText().contains(expectedCurrentAddress));

        WebElement resultPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        Assert.assertTrue(resultPermanentAddress.getText().contains(expectedPermanentAddress));


    }
}