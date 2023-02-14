package Pages;

import HelpMethod.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;
    public FrameMethods frameMethods;
    public WindowMethod windowMethod;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // specific pt JAVa
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);
        frameMethods = new FrameMethods(driver);
        windowMethod = new WindowMethod(driver);
    }
}
