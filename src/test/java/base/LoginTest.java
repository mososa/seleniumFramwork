package base;

import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests{
    LoginPage loginPageObject;

    @Test(priority = 1)
    public void loginWithCorrectCredential() {
        assertTrue(homePage.validateSliderIsDisplayed());
        loginPageObject = homePage.clickOnLoginorRegisterLink();
        assertTrue(loginPageObject.validateLoginTextElement("Login to your account"));
        loginPageObject.userCansuccessfulLogin("msosam@hotmail.com","Sthuc@hv123456");
        homePage.validateLoginAsIsDisplayed();
        homePage.clickOnLogoutLink();

    }
    @Test(priority = 2)
    public void loginWithInCorrectCredential() {
        assertTrue(loginPageObject.validateLoginTextElement("Login to your account"));
        loginPageObject.userCanNotLogin("cffxf@fxfx.com","Stc@54515");
        assertTrue( loginPageObject.validatefailedLoginText("Your email or password is incorrect!"));
    }


}
