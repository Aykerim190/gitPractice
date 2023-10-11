package com.digital.helper;

import com.digital.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.digital.driver.Driver.driver;

// в этом пакете хранятся кастомные методы наши
public class ElementActions { //Actions - действия с элементами







    // создаем явное ожидание
    public ElementActions waitButtonToBeClickAble(WebElement element){ // этот метод ждет пока будет кликабельным
        // для того, чтобы создавать свои методы cheining как ретернтип передаю название класса методу и дальше передаем в параметры(в скобках)
        // внутри этого метода пишем условие ->
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))//явное ожидание
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public ElementActions waitElementToBeVisible(WebElement element){//ждет пока данный элемент не появится на странице
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

        // создаем метод для клика
    public ElementActions clickTheButton(WebElement element){
        waitButtonToBeClickAble(element);
        actions.moveToElement(element).perform();
                element.click(); // ждем пока кнопка станет кликабельным // кликаем// под капотом ничего нет
        return this;

    }

       public ElementActions scrollToTheElement(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", element);
        return this;
    }

    //метод для SendKeys
    public ElementActions writeText(WebElement element, String txt){
        //перед тем,как увидеть это поле надо чтобы она была видна
        waitElementToBeVisible(element);
        actions.moveToElement(element).perform();
        element.sendKeys(txt);
        return this;
    }

    public ElementActions clickToRandomElement(List<WebElement> element){
        int randomIndex = new Random().nextInt(element.size());
        WebElement randomLabel = element.get(randomIndex);
        randomLabel.click();
        return this;
    }


    public ElementActions setTextAndEnterElement(String txt,WebElement element){
        writeText(element,txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    Actions actions= new Actions(Driver.getDriver());



}