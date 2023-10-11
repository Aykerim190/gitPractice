package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NambaFood extends BaseTest {
    @Test
    void orderFood() throws InterruptedException {
        driver.get("https://nambafood.kg/");
        WebElement foodOfNamba= driver.findElement(By.xpath("(//a[@href='/food'])[1]"));
        foodOfNamba.click();
        WebElement sushiFood= driver.findElement(By.xpath("//a[@href='/cafe/sushi']"));
        sushiFood.click();
        WebElement freshBox= driver.findElement(By.xpath("//div[@class='catalog-wrap']/a[4]"));
        freshBox.click();
        WebElement plusRhiladelfiya= driver.findElement(By.xpath("//div[@data-item-id='43861']/div[2]/div[2]"));
        plusRhiladelfiya.click();
        plusRhiladelfiya.click();
        plusRhiladelfiya.click();
        WebElement orderPhiladelfiya= driver.findElement(By.xpath("//div[@data-item-id='314428']/button"));
        orderPhiladelfiya.click();


        WebElement plusPepsi= driver.findElement(By.xpath("//div[@data-item-id='314428']/div[2]/div[2]"));
        plusPepsi.click();
        plusPepsi.click();
        WebElement orderPepsi= driver.findElement(By.xpath("//div[@data-item-id='314428']/button"));
        orderPepsi.click();


        WebElement clickBascet= driver.findElement(By.xpath("//div[@id='cart']"));
        clickBascet.click();
        WebElement checkOut= driver.findElement(By.xpath("//a[@href='/freshbox/checkout']"));
        checkOut.click();

        String expectedName= "food_order_client_name";
        WebElement fullNameInputField = driver.findElement(By.id(expectedName));
        fullNameInputField.sendKeys("Жылдыз");


        String expectedAdress="food_order_address";
        WebElement adressInputField= driver.findElement(By.id(expectedAdress));
        adressInputField.sendKeys("Карла Маркса 186");

        String expectedOrderDoor= "food_order_door_code";
        WebElement orderDoor= driver.findElement(By.id(expectedOrderDoor));
        orderDoor.sendKeys("2");

        String expectedPhone= "food_order_phone";
        WebElement phoneNumber= driver.findElement(By.id(expectedPhone));
        phoneNumber.sendKeys("0555357088");

        String additionalInfo= "food_order_additional_info";
        WebElement info= driver.findElement(By.id(additionalInfo));
        info.sendKeys("Приятного аппетита");
        Thread.sleep(7000);

    }

}