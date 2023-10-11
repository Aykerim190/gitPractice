package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeForm {

    @Test
    void studentRegistrationFormTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();//доступ к браузеру setup the chrome driver

        WebDriver driver = new ChromeDriver(); //в селениум , этот интерфейс позволяет управлять браузером create new object

        driver.manage().window().maximize();// make full screen

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstNameInputField = driver.findElement(By.id("firstName"));
        String expectedFirstName = "Aykerim";
        firstNameInputField.sendKeys(expectedFirstName);

        WebElement lastNameInputField = driver.findElement(By.id("lastName"));
        String expectedLastName = "Abdybek kyzy";
        lastNameInputField.sendKeys(expectedLastName);

        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        String expectedEmail = "john@gmail.com";
        userEmailField.sendKeys(expectedEmail);

        WebElement clickGenderBtn = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", clickGenderBtn);

        WebElement userNumberInputField = driver.findElement(By.id("userNumber"));
        String expectedUserNumber = "559416146";
        userNumberInputField.sendKeys(expectedUserNumber);

        WebElement dateOfBirthInputField = driver.findElement(By.id("dateOfBirthInput"));
// String expectedDateOfBirthInput = "20.03.1990";
// dateOfBirthInputField.sendKeys(expectedDateOfBirthInput);
//
        WebElement subjectsContainerField = driver.findElement(By.id("subjectsInput"));
        String expectedSubjectsContainer = "Selenium";
        subjectsContainerField.sendKeys(expectedSubjectsContainer);

        WebElement HobbiesBtn = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", HobbiesBtn);

        WebElement uploadPictureBtn = driver.findElement(By.id("uploadPicture"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",uploadPictureBtn);
// uploadPictureBtn.click();



        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        String expectedCurrentAddress = "10 mkr";
        currentAddressField.sendKeys(expectedCurrentAddress);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentAddressField);

        WebElement stateField = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", stateField);


        WebElement cityField = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", cityField);

        WebElement submitBtn = driver.findElement(By.id("submit"));
// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
      //  submitBtn.click();

    }

}