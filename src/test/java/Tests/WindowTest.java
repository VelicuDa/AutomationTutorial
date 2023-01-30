package Tests;

import HelpMethod.ElementMethod;
import HelpMethod.FrameMethods;
import HelpMethod.PageMethods;
import HelpMethod.WindowMethod;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WindowTest extends ShareData {

       @Test

    public void MetodaTest() {

        ElementMethod elementMethod = new ElementMethod(getDriver());
        PageMethods pageMethods = new PageMethods(getDriver());
        WindowMethod windowMethod = new WindowMethod(getDriver());

        WebElement SkipSignIn = getDriver().findElement(By.id("btn2"));
        elementMethod.ClickElement(SkipSignIn);

        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));

        elementMethod.MoveToElement(SwitchTo);

        WebElement WindowElement = getDriver().findElement(By.xpath("//a[text()='Windows']"));
        elementMethod.ClickElement(WindowElement);

        pageMethods.NavigateToPage("https://demo.automationtesting.in/Windows.html");

        List<WebElement> WindowOptions = getDriver().findElements(By.cssSelector(".nav-stacked>li>a"));
        elementMethod.ClickElement(WindowOptions.get(0));

        WebElement TabButon = getDriver().findElement(By.cssSelector("a>button"));
        elementMethod.ClickElement(TabButon);

        //identificam multimea de tab-uri/windows-uri
        //ne mutam cu focusul pe un tab specific
        windowMethod.MoveSpecificTabW(1);
        windowMethod.CloseCurentTabW();
        windowMethod.MoveSpecificTabW(0);

        //inchidem tabul curent

        WindowOptions.get(1).click();
        WebElement WindowButton = getDriver().findElement(By.cssSelector("#Seperate>button"));
        elementMethod.ClickElement(WindowButton);

        List<String> Windows = new ArrayList<>(getDriver().getWindowHandles());
        //ne mutam cu focusul pe un window specific
        windowMethod.MoveSpecificTabW(1);
        windowMethod.CloseCurentTabW();
        windowMethod.MoveSpecificTabW(0);

        WindowOptions.get(2).click();

        WebElement MultipleButton = getDriver().findElement(By.cssSelector("#Multiple>button"));
        elementMethod.ClickElement(MultipleButton);

        windowMethod.MoveSpecificTabW(2);
        windowMethod.CloseCurentTabW();
        windowMethod.MoveSpecificTabW(1);
        windowMethod.CloseCurentTabW();
        windowMethod.MoveSpecificTabW(0);



    }
}