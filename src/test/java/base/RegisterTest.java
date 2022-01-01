package base;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class RegisterTest extends BaseTests {

    LoginPage loginPageObject;
    SignUpPage signUpObject;
    AccountCreatedPage accountCreatedObject;
    DeleteAccountPage deleteAccountObject;


    @Test(priority = 1)
    public void testSuccessfullGoToRegisterationPage() {
        assertTrue(homePage.validateSliderIsDisplayed());
        loginPageObject = homePage.clickOnLoginorRegisterLink();
        assertTrue(loginPageObject.validateSignUpFormTextElement("New User Signup!"));
    }


    @Test(priority = 2, dependsOnMethods = {"testSuccessfullGoToRegisterationPage"})

    public void testUserCompleteAccountInformation() throws IOException, ParseException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.userRegistrationJsonReader();

        signUpObject = loginPageObject.userCanRegister(jsonReader.name, jsonReader.email);
        signUpObject.setPass(jsonReader.password);
        assertTrue(signUpObject.validateEnterAccountInformation("INFORMATION"));
        signUpObject.completeProfileData(jsonReader.password, jsonReader.DOBDay, jsonReader.DOBMonth, jsonReader.DOBYear);

    }

    @Test(priority = 3)
    public void completeAddProfileInformation() throws IOException, ParseException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.userRegistrationJsonReader();
        accountCreatedObject = signUpObject.addAddressInformation(jsonReader.firstName, jsonReader.lastName, jsonReader.company,
                jsonReader.address, jsonReader.country, jsonReader.state, jsonReader.city, jsonReader.zipCode, jsonReader.mobileNumber);
    }

    @Test(priority = 4)
    public void completeRegistration() {
        assertTrue(accountCreatedObject.accountCreatedText.isDisplayed());
        accountCreatedObject.clickOnContinueButton();
        assertTrue(homePage.validateLoginAsIsDisplayed());
        deleteAccountObject = homePage.clickOnDeleteAccount();

    }


}
