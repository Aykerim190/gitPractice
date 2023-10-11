import com.digital.driver.Driver;
import com.digital.pages.PracticeFormPage;
import com.digital.pages.TextBoxPage;
import com.digital.utils.FakeDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest { //теперь тести все тесты здесь, а не в классе мейн
    //раньше создавали объекты в каждом классе, теперь инициализируем здесь все  через наследование

    public WebDriver driver;
    public TextBoxPage textBoxPage;

    public PracticeFormPage practiceFormPage;
    public FakeDataProvider fakeDataProvider;

    // allure -> фреймворк, выдает отчеты


    @BeforeClass(alwaysRun = true)
    public void SetUpBrowser(){
       driver = Driver.getDriver();
       textBoxPage = new TextBoxPage();// уже проинициализирован, можно пользоваться уже
        practiceFormPage = new PracticeFormPage();
        fakeDataProvider = new FakeDataProvider();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        Driver.closeDriver();

    }
}
