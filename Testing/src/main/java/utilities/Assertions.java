package utilities;

import utilities.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class Assertions extends ElementActions {
    public SoftAssert feSoftAssert = new SoftAssert();
    // @After("@FERegression")
    public void logTCStatus()
    {
        feSoftAssert.assertAll();
    }
    //================================utilities.Assertions By locator============================
    //=================================Assert on existence of element=====================
    public void assertElementExist(By locator) {
//        try {
        assert getElement(locator).isDisplayed();
//            System.out.println("utilities.Assertions passed - Element by locator: [" + locator + "] exist successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("utilities.Assertions failed - Element by locator: [" + locator + "] not exist.");
//            Assert.fail();
//        }
    }

    public void assertElementNotExist(By locator) {
        try {
            assert getElement(locator).isDisplayed();
            System.out.println("utilities.Assertions failed - Element by locator: [" + locator + "] exist");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("utilities.Assertions passed - Element by locator: [" + locator + "] not exist.");
        }
    }
    //============================assert if element is enabled=================================
    public void assertElementEnabled(By locator) {
//        try {
        assertTrue(getElement(locator).isEnabled());
//            System.out.println("utilities.Assertions passed - Element by locator: [" + locator + "] is enabled");
//        } catch (AssertionError ae) {
//            ae.printStackTrace();
//            System.out.println("utilities.Assertions failed - Element by locator: [" + locator + "] not exist or disabled.");
//            Assert.fail();
//        }
    }

    public void assertElementDisabled(By locator) {
//        try {
        assertFalse(getElement(locator).isEnabled());
//            System.out.println("utilities.Assertions passed - Element by locator: [" + locator + "] not exist or disabled.");
//        } catch (AssertionError ae) {
//            ae.printStackTrace();
//            System.out.println("utilities.Assertions failed - Element by locator: [" + locator + "] is enabled.");
//            Assert.fail();
//        }
    }
    public void assertButtonEnabled(By locator, String disabledClassName) {
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertTrue((!isDisabled));
    }

    public void assertButtonDisabled(By locator, String disabledClassName) {
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertFalse((!isDisabled));
    }
    //===================================Assert element text=====================================
    public void assertElementText(By locator, String text) {
        String elementText = "";
//        try {
        elementText = getElement(locator).getText();
        assertEquals(elementText, text);
//            System.out.println("utilities.Assertions passed - Actual Text: [" + elementText + "] does match expected text successfully.");
//        } catch (AssertionError ae) {
//            ae.printStackTrace();
//            System.out.println("utilities.Assertions failed - Actual Text: [" + elementText + "] does not match expected text.");
//            Assert.fail();
//        }
    }
    public void assertTextContainsElementText(By locator, String text) {
        String elementText = "";
//        try {
        elementText = getElement(locator).getText();
        assertTrue(text.contains(elementText));
//            System.out.println("utilities.Assertions passed - Actual Text: [" + elementText + "] does match expected text successfully.");
//        } catch (AssertionError ae) {
//            ae.printStackTrace();
//            System.out.println("utilities.Assertions failed - Actual Text: [" + elementText + "] does not match expected text.");
//            Assert.fail();
//        }
    }
    //===================================Assert list size=====================================
    public void assertListSize(By locator, String size) {
        String listSize = "";
//        try {
        int listSizeInt = driver.findElements(locator).size();
        listSize = Integer.toString(listSizeInt);
        assertEquals(listSize, size);
//        } catch (AssertionError ae) {
//            ae.printStackTrace();
//            Assert.fail();
//        }
    }
    //========================================================================================
    //================================utilities.Assertions By Element============================
    //=================================Assert on existence of element=====================
    public void assertElementExist(WebElement element) {
        assert element.isDisplayed();
    }

    public void assertElementNotExist(WebElement element) {
        try {
            assert element.isDisplayed();
            System.out.println("utilities.Assertions failed - Element exist");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("utilities.Assertions passed - Element does not exist.");
        }
    }
    //============================assert if element is enabled=================================
    public void assertElementEnabled(WebElement element) {
        assertTrue(element.isEnabled());
    }

    public void assertElementDisabled(WebElement element) {
        assertFalse(element.isEnabled());
    }

    public void assertButtonEnabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertTrue((!isDisabled));
    }

    public void assertButtonDisabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertFalse((!isDisabled));
    }
    //===================================Assert element text=====================================
    public void assertElementText(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertEquals(elementText, text);
    }
    public void assertTextContainsElementText(WebElement element, String text) {
        String elementText = "";
        elementText = element.getText();
        assertTrue(text.contains(elementText));
    }
    //===================================Assert list size=====================================
    public void assertListSize(List<WebElement> element, String size) {
        String listSize = "";
        int listSizeInt = element.size();
        listSize = Integer.toString(listSizeInt);
        assertEquals(listSize, size);
    }
}
