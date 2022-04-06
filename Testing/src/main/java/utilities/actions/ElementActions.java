package utilities.actions;

import org.openqa.selenium.*;
import utilities.TestBase;

import java.util.List;

public class ElementActions extends TestBase {
    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            scrollPageToElement(element);
        } catch (Exception ignored) {
        }
        return element;
    }

    //get element by index
    public WebElement getElementByIndex(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        scrollPageToElement(element);
        return element;
    }

    //get index of element
    public int getIndexOfListByText(By locator, String selectionText) {
        int index = 0;
        List<WebElement> elementList = driver.findElements(locator);
        for(WebElement element : elementList){
            System.out.println(element.getText());
            if(selectionText.contains(element.getText())){
                if(element.getText().equals("-")) continue; //check for "-" is specialized because of access ID
                index = elementList.indexOf(element); break;
            }
        }
        return index;
    }

    //Scroll to a specific element using Locator
    public void scrollPageToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            actions.moveToElement(element).build().perform();
            highlightElement(element);
            unhighlightElement(element);
        } catch (Exception ignored) {
//            e.printStackTrace();
        }
    }

    //To highlight which button and field the script is currently clicking or typing in
    public void highlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('style', 'background: #ffffe6; border: 2px solid yellow;');", element);
    }

    //To remove the highlight
    public void unhighlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].removeAttribute('style','')", element);
    }

    //retrieve WebElement using xpath with different attributes(use to define any WebElements Object)
    public WebElement retrieveElementByAttributeValue(String attribute, String value) {
        return driver.findElement(By.xpath("//*[@" + attribute + "='" + value + "']"));
    }

    //used to force click on element using WebElement with java script(include scroll and wait)
    public void forceClickOnElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    //Switching to frame
    public void switchToFrame(By frameLocator) {
        WebElement frame = getElement(frameLocator);
        driver.switchTo().frame(frame);
    }
    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException Ex) {
            System.out.println("no alerts appear");
        }
    }
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        }
        catch (NoAlertPresentException Ex) {
            System.out.println("no alerts appear");
        }
    }
    //get list size
    public int getListSize(By locator)
    {
        return driver.findElements(locator).size();
    }
    //press tab
    public void pressTab(By locator)
    {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
    //press enter
    public void pressEnter(By locator)
    {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

}
