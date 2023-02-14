package Tests;

import HelpMethod.ElementMethod;
import Objects.RegisterObject;
import Pages.IndexPage;
import Pages.RegisterPage;

import ShareData.Hooks;
import org.checkerframework.common.initializedfields.qual.EnsuresInitializedFields;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends Hooks {
    @Test

    public void MetodaTest() {


        RegisterObject registerObject = new RegisterObject(TestData);
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.ClickSkipSignIn();
        testReport.attacheReport("pass", "Click  SkipSignIn button");

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registerProcess(registerObject);
        testReport.attacheReport("pass", "Fill register form");

    }
}
