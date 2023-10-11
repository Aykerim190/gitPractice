package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox extends BaseTest {
    @Test
    void checkTest() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");
        WebElement checkHome = driver.findElement(By.xpath("//button[@aria-label='Expand all']"));
        checkHome.click();
        Thread.sleep(7000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkHome);

        List<WebElement> tootleBtn = driver.findElements(By.xpath("//div[@id='tree-node']//span[@class='rct-checkbox']"));
        for (int i = 0; i < tootleBtn.size(); i++) {
            if (i == 0 || i == 1 || i == 4 || i == 5 || i == 9 || i == 14) {
            } else {
                System.out.println(i);
                WebElement tootle = tootleBtn.get(i);
                tootle.click();

            }
        }
        WebElement containsText = driver.findElement(By.id("result"));
        String text = "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        System.out.println(containsText.getText());
        Assert.assertTrue(containsText.getText().contains(text));

    }
}
