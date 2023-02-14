package Pages;

import Objects.AlertObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css=".nav-stacked>li>a")
    private List<WebElement> AlertOptions;

    @FindBy(css="#OKTab>button")
    private WebElement AlertOk;

    @FindBy(css="#CancelTab>button")
    private WebElement AlertOkCancel;

    @FindBy(css="#Textbox>button")
    private WebElement AlertText;

    public void InteractAlertAccept(){
        elementMethod.ClickElement(AlertOptions.get(0));
        elementMethod.ClickElement(AlertOk);
        alertMethods.AcceptAlert();
    }

    public void InteractAlertDismiss(){
        elementMethod.ClickElement(AlertOptions.get(1));
        elementMethod.ClickElement(AlertOkCancel);
        alertMethods.DismissAlert();
    }

    public void InteractAlertValue(AlertObject alertObject){
        elementMethod.ClickElement(AlertOptions.get(2));
        elementMethod.ClickElement(AlertText);
        alertMethods.FillAlert(alertObject.getAlertText(), true);
    }

}
