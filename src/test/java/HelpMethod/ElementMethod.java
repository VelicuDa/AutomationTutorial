package HelpMethod;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethod {
    private WebDriver driver;
    public ElementMethod(WebDriver driver) {

        this.driver = driver;
    }

    //facem metode generale pt interactiunile cu elemente
    public void ClickElement(WebElement Element){
        WaitElementVisible(Element);
        Element.click();
    }
    public void WaitElementVisible(WebElement Element){
        WebDriverWait WaitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        WaitExplicit.until(ExpectedConditions.visibilityOf(Element));
    }
    public void FillElement(WebElement Element, String Value){
        WaitElementVisible(Element);
        Element.sendKeys(Value);
    }
    public void ValidateElementText(WebElement Element, String Value){
        WaitElementVisible(Element);
        String Actual = Element.getText();
        Assert.assertEquals(Value, Actual);
    }
    public void SelectElementText(WebElement Element, String Value){
        WaitElementVisible(Element);
        Select ElementSelect = new Select(Element);
        ElementSelect.selectByVisibleText(Value);
    }
    public void SelectElementValue(WebElement Element, String Value) {
        WaitElementVisible(Element);
        Select ElementSelect = new Select(Element);
        ElementSelect.selectByValue(Value);
    }
    public void ScrollByPixel(Integer x, Integer y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }
    public void MoveToElement(WebElement Element){
        WaitElementVisible(Element);
        Actions actions = new Actions(driver);
        actions.moveToElement(Element).perform();
    }

}
