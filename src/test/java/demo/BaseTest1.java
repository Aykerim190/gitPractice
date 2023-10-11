package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.time.Duration;

public abstract class BaseTest1 {

    public WebDriver driver;

    @BeforeClass

    public void setUpBrowser(){

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        // WebDriverManager.chromedriver().setup();//доступ к браузеру setup the chrome driver// вместо этого вставили то,что сверху

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// setup the time неявное ожидание

        driver.get("https://demoqa.com/dynamic-properties");

        }


    @AfterClass
    public void tierDown(){
        driver.close();
        driver.quit();
    }
}
