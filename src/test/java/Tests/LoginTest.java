package Tests;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethods;
import Objects.LoginObject;
import Pages.IndexPage;
import Pages.LoginPage;

import ShareData.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {
    @Test

    public void MetodaTest() {
        LoginObject loginObject = new LoginObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.ClickSignIn();
        testReport.attacheReport("pass", "i click on sign button");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginInvalid(loginObject);
        testReport.attacheReport("pass", "i manage to validate invalid login");


    }

}
