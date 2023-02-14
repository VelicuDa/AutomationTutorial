package Pages;

import HelpMethod.ElementMethod;
import Objects.LoginObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

   @FindBy(css="ïnput[placeholder='E mail']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement parola;

    @FindBy(id="enterbtn")
    private WebElement Enter;

    @FindBy(id="errormsg")
    private WebElement error;

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public void LoginInvalid(LoginObject loginObject){

        elementMethod.FillElement(email, loginObject.getEmail());

        elementMethod.FillElement(parola, loginObject.getPassword());

        elementMethod.ClickElement(Enter);

        elementMethod.ValidateElementText(error, loginObject.getMessage());
    }


}
