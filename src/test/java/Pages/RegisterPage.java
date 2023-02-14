package Pages;

import Objects.RegisterObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "//a[text()='SwitchTo']")
    private WebElement SwitchTo;

    @FindBy(xpath = "//a[text()='Alerts']")
    private WebElement AlertElement;

    @FindBy(xpath="//a[text()='Frames']")
    private WebElement FrameElement;

    @FindBy(xpath = "//a[text()='Windows']")
    private WebElement WindowElement;

    @FindBy(css="input[placeholder='First Name']")
    private WebElement FirstName;

    @FindBy(xpath="//input[@placeholder='Last Name']")
    private WebElement LastName;

    @FindBy(xpath="//textarea[@ng-model='Adress']")
    private WebElement Adress;

    @FindBy(xpath="//input[@ng-model='EmailAdress']")
    private WebElement Email;

    @FindBy(xpath="//input[@ng-model='EmailAdress']")
    private WebElement Telefon;

    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement Gen;

    @FindBy(id="checkbox2")
    private WebElement Hobby;

    @FindBy(id="Skills")
    private WebElement Skills;

    @FindBy(id="yearbox")
    private WebElement Year;

    @FindBy(id="msdd")
    private WebElement Language;

    @FindBy(css=".ui-autocomplete>li>a")
    private List<WebElement> LanguageOptions;

    @FindBy(css=".select2-selection")
    private WebElement SelectCountry;

    @FindBy(className = "select2-search__field")
    private WebElement SelectCountryInput;

    @FindBy(css="select[placeholder='Month']")
    private WebElement Month;

    @FindBy(id = "daybox")
    private WebElement Day;

    @FindBy(id="firstpassword")
    private WebElement FirstPassword;

    @FindBy(id="secondpassword")
    private WebElement ConfirmPassword;

    @FindBy(id="submitbtn")
    private WebElement Submit;

    public void GoToAlert(){

        elementMethod.MoveToElement(SwitchTo);
        elementMethod.ClickElement(FrameElement);
        pageMethods.NavigateToPage("https://demo.automationtesting.in/Alerts.html");

    }
    public void GoToFrame(){

        elementMethod.MoveToElement(SwitchTo);
        elementMethod.ClickElement(AlertElement);
        pageMethods.NavigateToPage("https://demo.automationtesting.in/Frames.html");

    }

    public void GoToWindow(){

        elementMethod.MoveToElement(SwitchTo);
        elementMethod.ClickElement(WindowElement);
        pageMethods.NavigateToPage("https://demo.automationtesting.in/Windows.html");

    }

    public void registerProcess(RegisterObject registerObject){
        insertRegisterData(registerObject.getFirstName(), registerObject.getLastName(),
                registerObject.getAdress(), registerObject.getEmail(), registerObject.getTelefon());
        Gen(); SkillsInfo(registerObject.getLanguage(), registerObject.getpLanguage());
        selectCountry(registerObject.getCountry()); birthInfo(registerObject.getYear(),
                registerObject.getMonth(), registerObject.getDay());
        passWord(registerObject.getPassword(), registerObject.getConfirmPassword());
    }

    public void insertRegisterData(String firstNameValue,String lastNameValue, String adressValue, String emailValue, String telefonValue ){
        elementMethod.FillElement(FirstName, firstNameValue);
        elementMethod.FillElement(LastName, lastNameValue);
        elementMethod.FillElement(Adress, adressValue);
        elementMethod.FillElement(Email, emailValue);
        elementMethod.FillElement(Telefon, telefonValue);
    }

    public void Gen(){
        elementMethod.ClickElement(Gen);
    }


    public void SkillsInfo(String language, String pLanguage){
        elementMethod.ClickElement(Hobby);
        elementMethod.ScrollByPixel(0, 300);
        elementMethod.ClickElement(Language);

        // Interactionam cu o multime de elemente .Lista de Language care e element div
        String ExpectedLanguage = language;

        for(Integer i = 0; i<LanguageOptions.size(); i++){
            if(LanguageOptions.get(i).getText().equals(ExpectedLanguage)){ //chemam elementul, ii citim valoarea cu getText si verificam ca textul de pe element sa fie cu
                // variabila noastra
                elementMethod.ClickElement(LanguageOptions.get(i)); // pe elementul curent facem click
            }
        }
        elementMethod.SelectElementValue(Skills,pLanguage);

    }

    public void selectCountry(String countryValue){
        elementMethod.ClickElement(SelectCountry);
        elementMethod.FillElement(SelectCountry, countryValue);
        SelectCountry.sendKeys(Keys.ENTER);

    }

    public void birthInfo(String year, String month, String day) {
        elementMethod.SelectElementValue(Year, year);
        elementMethod.SelectElementValue(Month, month);
        elementMethod.SelectElementValue(Day, day);


    }
    public void passWord(String FirstPasswordValue, String ConfirmPasswordValue){
        elementMethod.FillElement(FirstPassword, FirstPasswordValue);
        elementMethod.FillElement(ConfirmPassword, ConfirmPasswordValue);

    }



}
