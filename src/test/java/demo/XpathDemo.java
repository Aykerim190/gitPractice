package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class XpathDemo extends BaseTest{

//    @Test
//    void absoluteXpath()throws InterruptedException{ //есть 2 способо находить элементы - с родителя (с корня) до элемента, ->absolut xpath -> html/body/div/div[2]...
//// минус в нестабильности и долго, при добавлении элементов,рисунком меняется структура, начало с одного слеша
//        driver.get("https://demoqa.com/automation-practice-form");
//        WebElement firstNameInputField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input"));
//        firstNameInputField.sendKeys("John");
//        Thread.sleep(7000);
//    }

    @Test
    void relativeXpath(){ // поиск конкретного тега, для этого начинаем с 2 слешов
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement lastNameInputField = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastNameInputField.sendKeys("Doe");

        WebElement emailInputField = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));

        WebElement mobNumberInputField = driver.findElement(By.xpath("//*[@id='userNumber']"));

        WebElement registrationFormText = driver.findElement(By.xpath("//*[text()='Student Registration Form']"));

        WebElement contains = driver.findElement(By.xpath("//*[contains(text(),'Student')]"));

        WebElement emailText = driver.findElement(By.xpath("//form/div[2]/div/label"));

       // WebElement currentAddress = driver.findElement(By.xpath("(//*[@id='currentAddress'])[2]"));

       // WebElement parent = driver.findElement(By.xpath("(//*[@id='currentAddress'])[2]/../..")); // Xpath может от дочернего подняться к родительсому тегу, важно интервью




    }
}
