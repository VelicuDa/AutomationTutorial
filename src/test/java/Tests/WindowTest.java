package Tests;

import Pages.IndexPage;
import Pages.RegisterPage;
import Pages.WindowPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class WindowTest extends Hooks {

       @Test

    public void MetodaTest() {

           IndexPage indexPage = new IndexPage(getDriver());
           indexPage.ClickSkipSignIn();
           testReport.attacheReport("pass", "Click  SkipSignIn button");

           RegisterPage registerPage = new RegisterPage(getDriver());
           registerPage.GoToWindow();
           testReport.attacheReport("pass", "Go to Windoes tab");

           WindowPage windowPage = new WindowPage(getDriver());
           windowPage.TabProcess();
           windowPage.WindowProcess();
           windowPage.TabsProcess();
           testReport.attacheReport("pass", "Manage tabs and windows");
       }
}