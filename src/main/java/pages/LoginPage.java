package pages;

import Common.CommonShared;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonShared {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement signUpFormTextElement = driver.findElement(By.xpath("//div[@class='signup-form']/h2"));
    private By userName = By.name("name");
    private By userEmail = By.xpath("//div[@class='signup-form']/form/input[@name='email']");
    WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));

    private By loginMailField = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    private By LoginBtn = By.xpath("//button[@data-qa='login-button']");
    private By loginLabel = By.xpath("//div[@class='login-form']/h2");
    private By failedLoginText = By.xpath("//form[@action='/login']/p");



    public boolean validatefailedLoginText(String str) {
        return getElementText(driver.findElement(failedLoginText)).contains(str);}

    public boolean validateSignUpFormTextElement(String str) {
        return getElementText(signUpFormTextElement).contains(str);
    }
    public boolean validateLoginTextElement(String str) {
        return getElementText(driver.findElement(loginLabel)).contains(str);
    }




    public SignUpPage userCanRegister(String username, String email) {
        setText(driver.findElement(userName), username);
        setText(driver.findElement(userEmail), email);
        clickButton(signUpButton);
        return new SignUpPage(driver);
    }

    public HomePage userCansuccessfulLogin(String email, String Pass){
        setText(driver.findElement(loginMailField), email);
        setText(driver.findElement(loginPasswordField), Pass);
        clickButton(driver.findElement(LoginBtn));
        return new HomePage(driver);
    }


    public void userCanNotLogin(String email, String Pass){
        setText(driver.findElement(loginMailField), email);
        setText(driver.findElement(loginPasswordField), Pass);
        clickButton(driver.findElement(LoginBtn));

    }

}
