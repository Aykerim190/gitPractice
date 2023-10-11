package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(id = "firstname")
    public WebElement firstNameInput;
    @FindBy(id = "lastname")
    public WebElement lastNameInput;
    @FindBy(id = "userName")
    public WebElement userNameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "recaptcha-anchor")
    public WebElement recaptchaAnchorClick;
    @FindBy(id = "btn btn-primary")
    public WebElement btnBtnPrimaryClick;

    public RegistrationPage fillUpFirstName(String txt) {
        elementActions.writeText(firstNameInput, txt);
        return this;

    }

    public RegistrationPage fillUpLastName(String txt) {
        elementActions.writeText(lastNameInput, txt);
        return this;
    }

    public RegistrationPage createUserName(String txt) {
        elementActions.writeText(userNameInput, txt);
        return this;
    }
    public RegistrationPage createPassword(String txt){
        elementActions.writeText(passwordInput,txt);
        return this;
    }
}
