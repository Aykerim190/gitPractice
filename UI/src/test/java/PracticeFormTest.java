import com.digital.models.Student;
import org.testng.annotations.Test;

import java.awt.*;

public class PracticeFormTest extends BaseTest{


    @Test
    void fillUpTheFormTest() throws InterruptedException, AWTException {

        driver.get("https://demoqa.com/automation-practice-form");
        Student student = fakeDataProvider.createFakeStudent();
        practiceFormPage.fillUpTheForm(student)
                .checkTheStudentDetails(student);






    }
}
