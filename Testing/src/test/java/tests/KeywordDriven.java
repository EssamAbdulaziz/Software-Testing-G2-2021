package tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.readers.ExcelReader;
import utilities.Paths;
import utilities.Screenshots;

import java.io.IOException;
@Listeners({ExtentITestListenerClassAdapter.class})
public class KeywordDriven extends LoginPage {
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    ExcelReader excelReader = new ExcelReader();
    Screenshots screenshots = new Screenshots();
    String keyword = "not assigned";
    int row = 1;
    //=======================================================
    @BeforeClass()
    public void loadLoginData()
    {
        String filePath = Paths.KEYWORD_DATA;
        try {
            excelReader.setPath(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login()
    {
        while(!keyword.equals("EndOfTest"))
        {
            try {
                keyword = excelReader.read(row, 0);
                if(keyword.equals("OpenWebSite"))
                {
                    homePage.openAutomationPractice();
                }
                else if(keyword.equals("clickSignIn"))
                {
                    homePage.clickSignIn();
                }
                else if(keyword.equals("typeEmail"))
                {
                    typeEmail(excelReader.read(row, 1));
                }
                else if(keyword.equals("typePassword"))
                {
                    typePassword(excelReader.read(row, 1));
                }
                else if(keyword.equals("typePassword"))
                {
                    typePassword(excelReader.read(row, 1));
                }
                else if(keyword.equals("clickSubmitLogin"))
                {
                    clickSubmit();
                }
                else if(keyword.equals("validateMyAccount"))
                {
                    myAccountPage.assertMyAccountTitle();
                }
                else if(keyword.equals("takeScreenshot"))
                {
                    screenshots.captureScreenShot("testScreenshot");
                }
                row++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
