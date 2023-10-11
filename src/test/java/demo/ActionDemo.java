package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionDemo extends BaseTest{ // для двойного нажатия кнопки баттон

    @Test
    void demo123(){

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        // для нажатия кнопки надо вызвать класс Actions именно selenium

        Actions actions = new Actions(driver); //объект, заглянуть в  класс Actions.class, и в параметры передать driver, управляет кликами

        actions.doubleClick(doubleClickButton).perform(); //метод doubleClick() нажимает 2 раза на кнопку и его не достаточно, надо добввить perform(), чтобы выполнил все действия
        WebElement doubleClickText = driver.findElement(By.xpath("//p[text()='You have done a double click']"));
        Assert.assertEquals(doubleClickText.getText(), "You have done a double click");

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform(); //actions -> кликает кнопки

        WebElement rightClickText = driver.findElement(By.xpath("//p[text()='You have done a right click']"));
        Assert.assertEquals(rightClickText.getText(), "You have done a right click");

        WebElement clickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickBtn).perform();

        WebElement clickBtnText = driver.findElement(By.xpath("//p[text()='You have done a dynamic click']"));
        Assert.assertEquals(clickBtnText.getText(), "You have done a dynamic click");




    }


}
