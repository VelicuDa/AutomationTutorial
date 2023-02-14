package HelpMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

    private WebDriver driver;
    public FrameMethods(WebDriver driver) {

        this.driver = driver;
    }
    public void switchframe(String value){

        driver.switchTo().frame(value);
    }
    public void switchframe(WebElement Element){
        driver.switchTo().frame(Element);

    }
    public void SwitchDefault(){

        driver.switchTo().defaultContent();
    }

}
