package pages;

import utilities.actions.ElementActions;
import org.openqa.selenium.By;
import utilities.Assertions;

public class MyAccountPage extends ElementActions{
    Assertions assertions = new Assertions();
    //=============================Locators==================================
    By myAccountTitle = By.cssSelector(".page-heading");
    //=============================Strings==================================
    String myAccountTitleText = "MY ACCOUNT";
    //===================================Actions===================================
    //-----------------------------------utilities.Assertions--------------------------------

    //------------------------------Text utilities.Assertions----------------------------------
    public void assertMyAccountTitle()
    {
        assertions.assertElementText(myAccountTitle, myAccountTitleText);
    }
}
