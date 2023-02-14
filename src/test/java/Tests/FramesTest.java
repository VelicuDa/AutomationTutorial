package Tests;

import HelpMethod.ElementMethod;
import HelpMethod.FrameMethods;
import HelpMethod.PageMethods;
import Objects.FrameObject;
import Pages.FramePage;
import Pages.IndexPage;
import Pages.RegisterPage;

import ShareData.Hooks;
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

public class FramesTest extends Hooks {
    @Test

    public void MetodaTest() {
        FrameObject frameObject = new FrameObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.ClickSkipSignIn();
        testReport.attacheReport("pass", "Click  SkipSignIn button");

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.GoToFrame();
        testReport.attacheReport("pass", "Go to frame");


        FramePage framePage = new FramePage(getDriver());
        framePage.SingleFrame(frameObject);
        framePage.MultipleFrame(frameObject);
        testReport.attacheReport("pass", "Manage multiple frames");




    }




}