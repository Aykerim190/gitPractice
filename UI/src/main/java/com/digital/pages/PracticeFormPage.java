package com.digital.pages;

import com.digital.models.Student;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class PracticeFormPage extends BasePage {
    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(id = "userNumber")
    public WebElement userNumberInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(xpath = "//div[contains(@class, 'custom-radio')]//label[@class='custom-control-label']")
    public List<WebElement> radioGenderButtons;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    public List<WebElement> hobbiesCheckboxList;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(xpath = "//div[@id='state']//div[@aria-hidden='true']")
    public WebElement inputState;

    @FindBy(id = "react-select-3-input")
    public WebElement inputForSetText;

    @FindBy(id = "react-select-4-input")
    public WebElement inputForSetCity;

    @FindBy(xpath = "//div[@id='state']//div[2]")
    public List<WebElement> containerForStateTexts;

    @FindBy(id = "subjectsInput")
    public WebElement subjects;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(id = "dateOfBirthInputField")
    public WebElement dataOfBirth;

    @FindBy(xpath = "//td[text()='Student Name']/../td[2]")
    public WebElement expectedName;
    @FindBy(xpath = "//td[text()='Student Email']/../td[2]")
    public WebElement expectedEmail;
    @FindBy(xpath = "//td[text()='Gender']/../td[2]")
    public WebElement expectedGender;
    @FindBy(xpath = "//td[text()='Mobile']/../td[2]")
    public WebElement expectedMobilePhone;
    @FindBy(xpath = "//td[text()='Date of Birth']/../td[2]")
    public WebElement expectedDate;
    @FindBy(xpath = "//td[text()='Subjects']/../td[2]")
    public WebElement expectedSubjects;
    @FindBy(xpath = "//td[text()='Hobbies']/../td[2]")
    public WebElement expectedHobbies;
    @FindBy(xpath = "//td[text()='Picture']/../td[2]")
    public WebElement expectedPicture;
    @FindBy(xpath = "//td[text()='Address']/../td[2]")
    public WebElement expectedAddress;
    @FindBy(xpath = "//td[text()='State and City']/../td[2]")
    public WebElement expectedStateAndCity;


    public PracticeFormPage fillUpTheFirstName(String txt) {
        elementActions.writeText(firstNameInput, txt);
        return this;
    }

    public PracticeFormPage fillUpTheLastName(String txt) {
        elementActions.writeText(lastNameInput, txt);
        return this;
    }

    public PracticeFormPage fillUpTheUserEmail(String txt) {
        elementActions.writeText(userEmailInput, txt);
        return this;
    }

    public PracticeFormPage clickGender() {
        elementActions.clickToRandomElement(radioGenderButtons);
        return this;
    }

    public PracticeFormPage fillUpTheCurrentAddress(String txt) {
        elementActions.writeText(currentAddressInput, txt);
        return this;
    }

    public PracticeFormPage clickHobbies() {
        elementActions.clickToRandomElement(hobbiesCheckboxList);
        return this;
    }

    public PracticeFormPage fillUpTheUserNumber(String txt) {
        elementActions.writeText(userNumberInput, txt);
        return this;
    }


    public PracticeFormPage UploadThePicture() {
        elementActions.writeText(uploadPicture, "C:\\Users\\Lenovo\\Downloads\\123.png");
        return this;
    }

    public PracticeFormPage selectState() {
        elementActions.clickTheButton(inputState);
        Map<String, String[]> stateAndCityList = new HashMap<>();
        String[] stateOfNcr = new String[]{"Delhi", "Gurgaon", "Noida"};
        String[] UP = new String[]{"Agra", "Lucknow", "Merrut"};
        String[] haryana = new String[]{"Karnal", "Panipat"};
        String[] rajasthan = new String[]{"Jaipur", "Jaiselmer"};
        for (WebElement state : containerForStateTexts) {
            if (state.getText().contains("NCR")) {
                stateAndCityList.put("NCR", stateOfNcr);
            } else if (state.getText().contains("Uttar Pradesh")) {
                stateAndCityList.put("Uttar Pradesh", UP);
            } else if (state.getText().contains("Haryana")) {
                stateAndCityList.put("Haryana", haryana);
            } else if (state.getText().contains("Rajasthan")) {
                stateAndCityList.put("Rajasthan", rajasthan);
            }
        }

        Random random = new Random();
        List<String> keysList = new ArrayList<>(stateAndCityList.keySet());
        String randomKey = keysList.get(random.nextInt(keysList.size()));
        String[] randomCities = stateAndCityList.get(randomKey);
        String randomCity = randomCities[random.nextInt(randomCities.length)];
        elementActions.setTextAndEnterElement(randomKey, inputForSetText);
        elementActions.setTextAndEnterElement(randomCity, inputForSetCity);
        return this;
    }

    public PracticeFormPage selectSubject() {
        elementActions.clickTheButton(subjects);
        List<String> subjectsList = new ArrayList<>();
        subjectsList.add("Accounting");
        subjectsList.add("Arts");
        subjectsList.add("Maths");
        subjectsList.add("Social Studies");
        subjectsList.add("Biology");
        subjectsList.add("Chemistry");
        subjectsList.add("Computer Science");
        subjectsList.add("Commerce");
        subjectsList.add("Hindi");
        subjectsList.add("English");
        subjectsList.add("Physics");
        subjectsList.add("Economics");
        subjectsList.add("History");

        Random random = new Random();

        String randomSubject = subjectsList.get(random.nextInt(subjectsList.size()));
        elementActions.writeText(subjects, randomSubject);
        elementActions.writeText(subjects, "" + Keys.ENTER);
        return this;
    }

    public PracticeFormPage clickTheSubmitBtn() {
        elementActions.clickTheButton(submitBtn);
        return this;

    }

    public PracticeFormPage fillUpTheForm(Student student) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        System.out.println("About to zoom in");
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        Thread.sleep(5000);
        System.out.println("About to zoom out");
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        Thread.sleep(3000);
        fillUpTheFirstName(student.getFirstName())
                .fillUpTheLastName(student.getLastName())
                .fillUpTheUserEmail(student.getEMail())
                .fillUpTheUserNumber(student.getPhoneNUmber())
                .fillUpTheCurrentAddress(student.getCurrentAddress())
                .clickHobbies()
                .clickGender()
                .UploadThePicture()
                .selectSubject()
                .selectState()
                .clickTheSubmitBtn();

        return this;

    }

    public PracticeFormPage checkTheStudentDetails(Student student) throws InterruptedException {

        System.out.println(expectedName.getText());
        Thread.sleep(2000);
        Assert.assertTrue(expectedName.getText().contains(student.getFirstName()));
        Assert.assertTrue(expectedName.getText().contains(student.getLastName()));
        Assert.assertTrue(expectedEmail.getText().contains(student.getEMail()));
        Assert.assertTrue(expectedAddress.getText().contains(student.getCurrentAddress()));
        System.out.println();
        Assert.assertTrue(expectedMobilePhone.getText().contains(student.getPhoneNUmber()));
        return this;
    }
}

