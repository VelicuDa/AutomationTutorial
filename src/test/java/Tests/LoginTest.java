package Tests;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends ShareData {

    @Test

    public void MetodaTest() {
        //Setam driverul pentru browser;

        //declaram un obiect si refactorizam actiunile
        ElementMethod elementMethod = new ElementMethod(getDriver());

        //declaram elementul Sign In;

        WebElement SignIn = getDriver().findElement(By.id("btn1"));
        elementMethod.ClickElement(SignIn);

        WebElement email = getDriver().findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "maria@gmail.com";
        elementMethod.FillElement(email, emailValue);

        WebElement parola = getDriver().findElement(By.xpath("//input[@placeholder='Password']"));
        String parolaValue = "Parola";
        elementMethod.FillElement(parola, parolaValue);

        WebElement Enter = getDriver().findElement(By.id("enterbtn"));
        elementMethod.ClickElement(Enter);

        //validam un mesaj de eroare

        WebElement error = getDriver().findElement(By.id("errormsg"));
        String expectederror = "Invalid User Name or PassWord";
        elementMethod.ValidateElementText(error, expectederror);

    }

}
