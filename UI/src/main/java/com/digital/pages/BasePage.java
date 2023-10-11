package com.digital.pages;

import com.digital.driver.Driver;
import com.digital.helper.ElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    ElementActions elementActions = new ElementActions();
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);//аннотации findBy без него не работает, только с этим драйвером

    }


}
