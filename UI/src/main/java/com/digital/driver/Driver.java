package com.digital.driver;

import com.digital.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {  // класс дирижер, новый файл в ресурсах

private Driver(){ // если конструктор private - не можем создавать объекты, т.е. этот класс должен быть в единств.экземпляре
    // данный подход (или способ) называется Singleton pattern - одиночка

}

public static WebDriver driver;

public static WebDriver getDriver(){
    if (driver == null){
        switch (ConfigReader.getProperty("browser").toLowerCase()){
            case "chrome":
                driver = ChromeWebDriver.loadChromeDriver();
                break;
            case "edge":
                driver = FirefoxWebDriver.loadFireFoxWebDriver();
                break;

            default:
                throw new IllegalArgumentException("You provided wrong Driver name");
        }

    }
    return driver;
}

  public static void closeDriver(){ //закрывающий метод драйвер
    try{
        if (driver!=null){
            driver.close();
            driver.quit();
            driver=null; //иначе останется с последним значением
        }
    }catch(Exception e){
        System.out.println("Error while closing the driver");
    }


  }
}
