package Tests;

import HelpMethod.ElementMethod;
import HelpMethod.FrameMethods;
import HelpMethod.PageMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;

import java.awt.*;
import java.time.Duration;

public class FramesTest extends ShareData {

    @Test

    public void MetodaTest() {
        ElementMethod elementMethod = new ElementMethod(getDriver());
        PageMethods pageMethods = new PageMethods(getDriver());
        FrameMethods frameMethods = new FrameMethods(getDriver());

        WebElement SkipSignIn = getDriver().findElement(By.id("btn2"));
        elementMethod.ClickElement(SkipSignIn);

        //wait explicit cu conditii diferite

        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));

        //mergem cu mouse-ul pe un anumit element
        elementMethod.MoveToElement(SwitchTo);

        WebElement FrameElement = getDriver().findElement(By.xpath("//a[text()='Frames']"));
        elementMethod.ClickElement(FrameElement);

        pageMethods.NavigateToPage("https://demo.automationtesting.in/Frames.html");

        List<WebElement> FrameOptions = getDriver().findElements(By.cssSelector(".nav-tabs>li>a"));
        elementMethod.ClickElement(FrameOptions.get(0));

        //ne mutam pe un frame
        //getDriver().switchTo().frame("singleframe");
        frameMethods.switchframe("singleframe");


        //linia aceasta ne-a bagat in acest frame - in dreptunghi

        WebElement FirstFrame = getDriver().findElement(By.cssSelector("input[type='text']"));
        elementMethod.FillElement(FirstFrame, "test");

        frameMethods.SwitchDefault();

        elementMethod.ClickElement(FrameOptions.get(1));

        frameMethods.switchframe(getDriver().findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.switchframe(getDriver().findElement(By.cssSelector("iframe[src='SingleFrame.html']")));

        WebElement SecondFrame = getDriver().findElement(By.cssSelector("input[type='text']"));
        elementMethod.FillElement(SecondFrame, "test2");
        frameMethods.SwitchDefault();
    }




}