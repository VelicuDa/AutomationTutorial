package Tests;

import HelpMethod.ElementMethod;
import ShareData.ShareData;
import org.checkerframework.common.initializedfields.qual.EnsuresInitializedFields;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends ShareData {
    @Test

    public void MetodaTest() {

        ElementMethod elementMethod = new ElementMethod(getDriver());

        WebElement SkipSignin = getDriver().findElement(By.id("btn2"));
        elementMethod.ClickElement(SkipSignin);

        WebElement FirstName = getDriver().findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstnamevalue = "Maria";
        elementMethod.FillElement(FirstName, firstnamevalue);

        WebElement LastName = getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastnamevalue = "Ioana";
        elementMethod.FillElement(LastName, lastnamevalue);


        WebElement Adress = getDriver().findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String adressvalue = "Calarasi";
        elementMethod.FillElement(Adress, adressvalue);

        WebElement Email = getDriver().findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        String emailvalue = "maria@gmail.com";
        elementMethod.FillElement(Email, emailvalue);

        WebElement Telefon = getDriver().findElement(By.xpath("//input[@ng-model='Phone']"));
        String Telefonvalue = "0712345678";
        elementMethod.FillElement(Telefon, Telefonvalue);

        WebElement Gen = getDriver().findElement(By.xpath("//input[@value='FeMale']"));
        elementMethod.ClickElement(Gen);

        WebElement Hobby = getDriver().findElement(By.id("checkbox2"));
        elementMethod.ClickElement(Hobby);

        //interactionam cu un drop down clasic

        WebElement Skills = getDriver().findElement(By.id("Skills"));
        elementMethod.SelectElementText(Skills, "Java");

        WebElement Year = getDriver().findElement(By.id("yearbox"));
        elementMethod.SelectElementValue(Year, "1997");

        elementMethod.ScrollByPixel(0,300);

        WebElement Language=getDriver().findElement(By.id("msdd"));
        elementMethod.ClickElement(Language);

        //interactionam cu o multime de elemente - drop down complex

        List<WebElement> LanguageOptions = getDriver().findElements(By.cssSelector(".ui-autocomplete>li>a"));
        String ExpectedLanguage = "English";
        for (Integer index = 0; index <LanguageOptions.size(); index ++){
            if (LanguageOptions.get(index).getText().equals(ExpectedLanguage)) {
                elementMethod.ClickElement(LanguageOptions.get(index));
            }

        }
        elementMethod.ClickElement(Gen);

        WebElement SelectCountry = getDriver().findElement(By.cssSelector(".select2-selection"));
        elementMethod.ClickElement(SelectCountry);
        WebElement SelectCountryInput = getDriver().findElement(By.className("select2-search__field"));
        elementMethod.FillElement(SelectCountryInput, "Australia");

        WebElement Month = getDriver().findElement(By.cssSelector("select[placeholder='Month']"));
        elementMethod.SelectElementText(Month, "August");

        WebElement Day = getDriver().findElement(By.id("daybox"));
        elementMethod.SelectElementValue(Day, "15");

        WebElement FirstPassword = getDriver().findElement(By.id("firstpassword"));
        String firstpasswordValue = "Cristian";
        elementMethod.FillElement(FirstPassword, firstpasswordValue);

        WebElement ConfirnPassword = getDriver().findElement(By.id("secondpassword"));
        String confirmpasswordValue = "Cristian";
        elementMethod.FillElement(ConfirnPassword, confirmpasswordValue);

        WebElement Submit = getDriver().findElement(By.id("submitbtn"));
        elementMethod.ClickElement(Submit);

    }
}
