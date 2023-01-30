package HelpMethod;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethod {

    private WebDriver driver;

    public WindowMethod(WebDriver driver) {

        this.driver = driver;
    }
    public void MoveSpecificTabW(Integer index){
        List<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(index));

    }
    public void CloseCurentTabW(){
        driver.close();

    }
}
