package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends BasePage{

    public WindowPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css=".nav-stacked>li>a")
    private List<WebElement> WindowOptions;

    @FindBy(css="Tabbed>a>button")
    private WebElement TabButon;

    @FindBy(css="#Seperate>button")
    private WebElement WindowButton;

    @FindBy(css="#Multiple>button")
    private WebElement MultipleButton;

    public void TabProcess(){
        elementMethod.ClickElement(WindowOptions.get(0));
        elementMethod.ClickElement(TabButon);
        windowMethod.MoveSpecificTabW(1);
        windowMethod.CloseCurentTabW();
        windowMethod.MoveSpecificTabW(0);
    }

    public void WindowProcess(){
        WindowOptions.get(1).click();
        elementMethod.ClickElement(WindowButton);
        windowMethod.MoveSpecificTabW(1);
        driver.close();
        windowMethod.MoveSpecificTabW(0);
    }

    public void TabsProcess(){
        WindowOptions.get(2).click();
        elementMethod.ClickElement(MultipleButton);
        windowMethod.MoveSpecificTabW(2);
        windowMethod.CloseCurentTabW();
        windowMethod.MoveSpecificTabW(1);
        windowMethod.CloseCurentTabW();
        windowMethod.MoveSpecificTabW(0);
    }

}
