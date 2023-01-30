package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends ShareData {
    @Test

    public void MetodaTest() throws InterruptedException {

        WebElement SkipSignIn = getDriver().findElement(By.id("btn2"));
        SkipSignIn.click();

        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(SwitchTo).perform();

        WebElement WindowElement = getDriver().findElement(By.xpath("//a[text()='Windows']"));
        WindowElement.click();
        getDriver().navigate().to("https://demo.automationtesting.in/Windows.html");

        List<WebElement> WindowOptions = getDriver().findElements(By.cssSelector(".nav-stacked>li>a"));
        WindowOptions.get(0).click();

        WebElement TabButon = getDriver().findElement(By.cssSelector("#Tabbed>a>button"));
        TabButon.click();

        //identificam multimea de tab-uri/windowsuri

        List<String> Tabs = new ArrayList<>(getDriver().getWindowHandles());

        //ne mutam cu focusul pe un tab specific

        getDriver().switchTo().window(Tabs.get(1));

        //inchidem tabul curent

        getDriver().close();
        getDriver().switchTo().window(Tabs.get(0));

        WindowOptions.get(1).click();
        WebElement WindowButton = getDriver().findElement(By.cssSelector("#Seperate>button"));
        WindowButton.click();

        List<String> Windows = new ArrayList<>(getDriver().getWindowHandles());
        //ne mutam cu focusul pe un window specific
        getDriver().switchTo().window(Windows.get(1));
        getDriver().close();
        getDriver().switchTo().window(Windows.get(0));

        WindowOptions.get(2).click();

        WebElement MultipleButton = getDriver().findElement(By.cssSelector("#Multiple>button"));
        MultipleButton.click();

        List<String> Multiple = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(Multiple.get(2));
        getDriver().close();
        getDriver().switchTo().window(Multiple.get(1));
        getDriver().close();
        getDriver().switchTo().window(Multiple.get(0));


    }
}