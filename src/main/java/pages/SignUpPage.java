package pages;

import Common.CommonShared;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends CommonShared {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public WebElement enterAccountInformation = driver.findElement(By.cssSelector("h2.title.text-center:nth-child(1)>b"));
    private By password = By.id("password");
    private WebElement userTitle = driver.findElement(By.id("id_gender1"));
    private WebElement userProfilePassword = driver.findElement(By.id("password"));
    private WebElement selectBirthDay = driver.findElement(By.id("days"));
    private WebElement selectBirthMonth = driver.findElement(By.id("months"));
    private WebElement selectBirthYear = driver.findElement(By.id("years"));
    private WebElement newsletter = driver.findElement(By.id("newsletter"));
    private WebElement specialOffers = driver.findElement(By.id("optin"));
    private WebElement firstName = driver.findElement(By.id("first_name"));
    private WebElement lastName = driver.findElement(By.id("last_name"));
    private WebElement company = driver.findElement(By.id("company"));
    private WebElement address = driver.findElement(By.id("address1"));
    private WebElement country = driver.findElement(By.id("country"));
    private WebElement state = driver.findElement(By.id("state"));
    private WebElement city = driver.findElement(By.id("city"));
    private WebElement zipcode = driver.findElement(By.id("zipcode"));
    private WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
    private WebElement creatAccountBtn = driver.findElement(By.cssSelector("button.btn.btn-default"));


    public void completeProfileData(String str, String bdd, String bdm, String bdy) {
        clickButton(userTitle);
        setText(userProfilePassword, str);
        selectFromDropdownBySelect(selectBirthDay, bdd);
        selectFromDropdownBySelect(selectBirthMonth, bdm);
        selectFromDropdownBySelect(selectBirthYear, bdy);
        clickButton(newsletter);
        clickButton(specialOffers);


    }
    public AccountCreatedPage addAddressInformation(String fname, String lname, String com, String add,
                              String countr, String ustate,String ucity, String zipcod, String mobileNum  )
    { setText(firstName,fname);
        setText(lastName,lname);
        setText(company,com);
        setText(address,add);
        selectFromDropdownBySelect(country,countr);
        setText(state,ustate);
        setText(city,ucity);
        setText(zipcode,zipcod);
        setText(mobileNumber,mobileNum);
        clickButton(creatAccountBtn);
        return new AccountCreatedPage(driver); }


    public boolean validateEnterAccountInformation(String str) {
        return getElementText(enterAccountInformation).contains(str);
    }

    public void setPass(String str) {
        setText(driver.findElement(password), str);
    }


}

