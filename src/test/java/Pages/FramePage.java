package Pages;

import Objects.FrameObject;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css=".nav-tabs>li>a")
    private List<WebElement> FrameOptions;

    @FindBy(css="input[type='text']")
    private WebElement FirstFrame;

    @FindBy(css="input[type='text']")
    private WebElement SecondFrame;

    public void SingleFrame(FrameObject frameObject){
        elementMethod.ClickElement(FrameOptions.get(0));
        frameMethods.switchframe("singleframe");
        elementMethod.FillElement(FirstFrame, frameObject.getFirstFrame());
        frameMethods.SwitchDefault();

    }

    public void MultipleFrame(FrameObject frameObject){
        elementMethod.ClickElement(FrameOptions.get(1));

        frameMethods.switchframe(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.switchframe(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        elementMethod.FillElement(FirstFrame, frameObject.getSecondFrame());
        elementMethod.FillElement(SecondFrame, "multipleframe");
        frameMethods.SwitchDefault();
    }


}
