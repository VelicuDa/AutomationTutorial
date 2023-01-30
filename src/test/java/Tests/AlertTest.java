package Tests;

import HelpMethod.AlertMethods;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethods;
import ShareData.ShareData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AlertTest extends ShareData {

    public WebDriver driver;

    @Test

    public void MetodaTest() {
        ElementMethod elementMethod = new ElementMethod(getDriver());
        PageMethods pageMethods = new PageMethods(getDriver());
        AlertMethods alertMethods = new AlertMethods(getDriver());

        WebElement SkipSignIn = driver.findElement(By.id("btn2"));
        elementMethod.ClickElement(SkipSignIn);

        WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));

        // mergem cu mouse-ul pe un anumit element
        elementMethod.MoveToElement(SwitchTo);

        WebElement AlertElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        elementMethod.ClickElement(AlertElement);

        //navigam catre un url
        pageMethods.NavigateToPage("https://demo.automationtesting.in/Alerts.html");

        List<WebElement> AlertOptions = driver.findElements(By.cssSelector(".nav-stacked>li>a"));
        elementMethod.ClickElement(AlertOptions.get(0));

        WebElement AlertOk = driver.findElement(By.cssSelector("#OKTab>button"));
        elementMethod.ClickElement(AlertOk);

        //interactionam cu o alerta

        alertMethods.AcceptAlert();

        elementMethod.ClickElement(AlertOptions.get(1));

        WebElement AlertOkCancel = driver.findElement(By.cssSelector("#CancelTab>button"));
        elementMethod.ClickElement(AlertOkCancel);

        alertMethods.DismissAlert();

        elementMethod.ClickElement(AlertOptions.get(2));

        WebElement AlertText = driver.findElement(By.cssSelector("#Textbox>button"));
        elementMethod.ClickElement(AlertText);

        alertMethods.FillAlert("test", true);


    }
}
