package pages;

import Common.CommonShared;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends CommonShared {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By textInSlider = By.id("slider-carousel");
    public By LoginAsText = By.partialLinkText("Logged in as");
    private By LoggedInTextVerification = By.partialLinkText("Logged in as");

    public boolean validateSliderIsDisplayed(){
        return driver.findElement(textInSlider).isDisplayed();
    }
    public boolean validateLoginAsText(String str) {
        return getElementText(driver.findElement(LoginAsText)).contains(str);
    }


    public LoginPage clickOnLoginorRegisterLink(){
        clickLink("Signup / Login");
        return new LoginPage(driver);
    }
    public LoginPage clickOnLogoutLink(){
        clickLink("Logout");
        return new LoginPage(driver);
    }
    public DeleteAccountPage clickOnDeleteAccount(){
        clickLink("Delete Account");
        return new DeleteAccountPage(driver);
    }
    public boolean validateLoginAsIsDisplayed(){
        return driver.findElement(LoggedInTextVerification).isDisplayed();
    }






}
