package Pages;
import HelpMethod.ElementMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {

    //elemente specifice de aceasta pagina
    @FindBy(id="btn1")
    private WebElement SignIn;

    @FindBy(id="btn2")
    private WebElement SkipSignIn;

    public IndexPage(WebDriver driver) {

        super(driver);
    }
    //actiuni specifice pt IndexPage
    public LoginPage ClickSignIn() {

        elementMethod.ClickElement(SignIn);
        return new LoginPage(driver);
    }
        public RegisterPage ClickSkipSignIn(){

        elementMethod.ClickElement(SkipSignIn);
        return new RegisterPage(driver);

        }


}
