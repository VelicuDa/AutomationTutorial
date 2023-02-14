package Tests;

import Objects.AlertObject;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;

import ShareData.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

    @Test

    public void MetodaTest() {
        AlertObject alertObject = new AlertObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.ClickSkipSignIn();
        testReport.attacheReport("pass", "Click  SkipSignIn button");


        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.GoToAlert();
        testReport.attacheReport("pass", "Go to Alert");


        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.InteractAlertAccept();
        alertPage.InteractAlertDismiss();
        alertPage.InteractAlertValue(alertObject);
        testReport.attacheReport("pass", "Manage to close multiple alerts type");

    }


}
