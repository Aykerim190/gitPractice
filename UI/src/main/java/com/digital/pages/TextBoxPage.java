package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.digital.driver.Driver.driver;

public class TextBoxPage extends BasePage{
    @FindBy(id = "userName")
    public WebElement fullNameInput;
    @FindBy(id = "userEmail")
    public WebElement userEmailInput;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;
    @FindBy(id = "submit")
    public WebElement submit;
    @FindBy(id = "name")
    public WebElement expectedFullNameInput;
    @FindBy(id = "email")
    public WebElement expectedUserEmailInput;
    @FindBy(xpath = "//p[@id='currentAddress']")
    public WebElement expectedCurrentAddressInput;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    public WebElement expectedPermanentAddressInput;
    public TextBoxPage fillUpTheFullName(String FullName){
        elementActions.writeText(fullNameInput, FullName);
        return this;
    }
    public TextBoxPage fillUpTheEmail(String email){
        elementActions.writeText(userEmailInput, email);
        return this;
    }
    public TextBoxPage fillUpTheCurrentAddress(String currentAddress){
        elementActions.writeText(currentAddressInput, currentAddress);
        return this;
    }
    public TextBoxPage fillUpThePermanentAddress (String permanentAddress){
        elementActions.writeText(permanentAddressInput, permanentAddress);
        return this;
    }
    public TextBoxPage submitClick(){
        elementActions.scrollToTheElement(submit).clickTheButton(submit);
        return this;
    }
    public TextBoxPage testTextBoxPage(){
        Assert.assertTrue(expectedFullNameInput.getText().contains(fullNameInput.getText()));
        Assert.assertTrue(expectedUserEmailInput.getText().contains(userEmailInput.getText()));
        Assert.assertTrue(expectedUserEmailInput.getText().contains(currentAddressInput.getText()));
        Assert.assertTrue(expectedPermanentAddressInput.getText().contains(permanentAddressInput.getText()));
        return this;
    }
}
// домашка заполнить все методы Textbox, также создать метод,который заполняет всю форму и также проверки