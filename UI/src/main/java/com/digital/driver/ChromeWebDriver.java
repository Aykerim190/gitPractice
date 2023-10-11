package com.digital.driver;


import com.digital.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.digital.driver.Driver.driver;

//  в пакете драйвер храянтся классы драйверов,нр хром драйвер,файерфоксдрайвер
public class ChromeWebDriver {

    public static WebDriver loadChromeDriver(){ // возвращаемый тип Webdriver

        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions(); //можем передать какие-либо параметры браузеру

        options.addArguments("--disable-extensions"); //вызываем объект options отключить все расширения браузеру, правый верхний угол

        if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))){
            options.addArguments("--headless"); // если в настройках хедлесс тру, то обычный стринг начинаем парсить(переобразовывать) в булиан

        }


        WebDriver driver = new ChromeDriver(options); // создали объект драйвера и нужно передать все настройки options в этот драйвер объект

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();

        return driver;





    }
}
