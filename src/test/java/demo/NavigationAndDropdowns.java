package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class NavigationAndDropdowns extends BaseTest{

    @Test
    void Demo1() throws InterruptedException {
        // driver.get() вместо этого navigate.to() / get не запоминает предыдущие страницы

        driver.navigate().to("https://nambafood.kg/"); // запоминает страницы предыдущие

        driver.findElement(By.xpath("//a[@href='/food'][1]")).click();
        Thread.sleep(4000);
        // методы navigate()
        driver.navigate().back();
        Thread.sleep(4000);
        driver.navigate().forward();
        Thread.sleep(4000);
        driver.navigate().refresh();
        Thread.sleep(4000);
    }
        @Test
                void demo2() throws InterruptedException {
            driver.get("https://demoqa.com/select-menu");
//            WebElement selectColor = driver.findElement(By.id("oldSelectMenu")); // выпадающее меню select/ В selenium есть класс select
//
//            Select select = new Select(selectColor);
//            select.selectByVisibleText("Green");
//            Thread.sleep(3000);
//
//            select.selectByValue("4");
//            Thread.sleep(3000);
//
//            select.selectByIndex(7);//violet
//            Thread.sleep(3000);
//
//            List <WebElement> selectOptions = select.getAllSelectedOptions(); // выводит только выбранные элементы
//            for (WebElement options: selectOptions){
//                System.out.println(options.getText());
//
//            }
//
//            List <WebElement> selectOptions1 = select.getOptions(); // сохранит все значения
//            for (WebElement options: selectOptions1){
//                System.out.println(options.getText());
//            }
 //если есть всплывающее окно, надо проверить есть ли тег select, если нет работаем напряму с Input
            WebElement selectReact = driver.findElement(By.id("react-select-2-input"));
            selectReact.sendKeys("Group 1, option 1");
            selectReact.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
        }

    }
