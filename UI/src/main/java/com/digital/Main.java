package com.digital;

import com.digital.driver.Driver;
import com.digital.helper.AlertHelper;
import com.digital.helper.ScreenShotMethods;
import com.digital.models.Student;
import com.digital.pages.PracticeFormPage;
import com.digital.pages.TextBoxPage;
import com.digital.utils.FakeDataProvider;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class Main {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = Driver.getDriver();
    }

    @Test

    public void testTextBoxPage (){

        driver.get("https://demoqa.com/text-box");
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.fillUpTheFullName("Nurik").fillUpTheEmail("nurik@mail.ru")
                .fillUpTheCurrentAddress("Bishkek")
                .fillUpThePermanentAddress("Bishkek")
                .submitClick()
                .testTextBoxPage();
    }

    @Test
    public void test1() throws InterruptedException, AWTException {
        driver.get("https://demoqa.com/automation-practice-form");
        FakeDataProvider fakeDataProvider = new FakeDataProvider();
        Student student = new Student();
        student.setFirstName("Jyldyz");
        student.setLastName("Jeenbaeva");
        student.setEMail("Jilduz@gmail.com");
        student.setCurrentAddress("Lenina 268");
        student.setPhoneNUmber("9965553570");
        PracticeFormPage practiceFormPages = new PracticeFormPage();
        practiceFormPages.fillUpTheForm(student).checkTheStudentDetails(student);
    }
//    @AfterClass
//    public void finishSession(){Driver.closeDriver();}

//        @Test
//                //alert - предупреждение , всплывающее окно
//        void test2() throws InterruptedException {
//        driver.get("https://demoqa.com/alerts");
//        driver.findElement(By.id("alertButton")).click();
//            //  у алерта нет локаторов и он не относится к вебэлементу
//            // у алерта для этого есть интерфейс Alert
//        Alert alert = driver.switchTo().alert(); // вызываем интерфейс алерт и говорим драйверу переключись на алерт
//        Thread.sleep(2000);// в будущем не использовать
//        alert.accept(); // кликает кнопку принять или ок
//           driver.findElement(By.id("timerAlertButton")).click();//сохраняем в вебэлемент
//
//            // создаем ожидание
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.alertIsPresent());
//            alert.accept();
//
//            driver.findElement(By.id("confirmButton")).click();
//            alert.dismiss();//отклонить
//
//            driver.findElement(By.id("promtButton")).click();
//
//            alert.sendKeys("Nuta");
//            alert.accept();
//
//}

//    @Test
//    public void testToAlert() throws InterruptedException {
//        WebDriver driver = Driver.getDriver();
//        AlertHelper alertHelper = new AlertHelper();
//        driver.get("https://demoqa.com/alerts");
//        driver.findElement(By.id("alertButton")).click();
//        Thread.sleep(5000);
//        alertHelper.acceptAlert();
//        driver.findElement(By.id("timerAlertButton")).click();
//        alertHelper.acceptAlert();
//        Thread.sleep(2000);
//        driver.findElement(By.id("confirmButton")).click();
//        alertHelper.dismissAlert();
//        driver.findElement(By.id("promtButton")).click();
//        alertHelper.sendKeysAlert("Jildiz");
//    }

    @Test
    void test12() { // фрейм-внутри хтмл лежит другой хтмл,для этого надо переключиться между фреймами
        // можем переключаться 3 способами
        // 1. По индексу
        //2. по ID
        //3. по веб элементу
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");// от этого фрейма идем к внутреннему
        WebElement text = driver.findElement(By.tagName("h1"));
        System.out.println(text.getText());
        driver.switchTo().defaultContent(); //перекидывает на корневой хтмл(на основной)
        WebElement div = driver.findElement(By.xpath("//div[@id='framesWrapper']/div"));
        System.out.println(div.getText());

    }

    @Test
    void test13() throws IOException {

        ScreenShotMethods screenShotMethods = new ScreenShotMethods(); // содаем объект скриншот
        driver.get("https://demoqa.com/nestedframes");
        //first go to parent frame
        driver.switchTo().frame("frame1");
        // then go to child frame
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.switchTo().parentFrame();// возвращаемя на родительский фрейм
        System.out.println(driver.findElement(By.tagName("body")).getText());

       screenShotMethods.takeScreenShot(); //вызвали метод скриншота
        driver.switchTo().defaultContent();//

    }

}