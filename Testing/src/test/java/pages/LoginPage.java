package pages;

import utilities.actions.ElementActions;
import org.openqa.selenium.By;

public class LoginPage extends ElementActions {
    //=============================Locators==================================
    By email = By.id("email");
    By password = By.id("passwd");
    By submitLogin = By.id("SubmitLogin");
    //=============================Strings==================================

    //===================================Actions===================================
    public void typeEmail(String emailValue)
    {
        getElement(email).sendKeys(emailValue);
    }
    public void typePassword(String passwordValue)
    {
        getElement(password).sendKeys(passwordValue);
    }
    public void clickSubmit()
    {
        getElement(submitLogin).click();
    }
    //-----------------------------------utilities.Assertions--------------------------------

    //------------------------------Text utilities.Assertions----------------------------------

}
