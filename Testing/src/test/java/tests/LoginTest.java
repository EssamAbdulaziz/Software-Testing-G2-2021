package tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.Screenshots;
@Listeners({ExtentITestListenerClassAdapter.class})
public class LoginTest extends LoginPage {
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Screenshots screenshots = new Screenshots();

    //=======================================================
    @Test
    public void login()
    {
        try {
            homePage.openAutomationPractice();
            homePage.clickSignIn();
            typeEmail("test@yahoo.com");
            typePassword("Test@123");
            clickSubmit();
            myAccountPage.assertMyAccountTitle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void takeScreenShot()
    {
        screenshots.captureScreenShot("testScreenshot");
    }
}
