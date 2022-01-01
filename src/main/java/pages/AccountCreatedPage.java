package pages;

import Common.CommonShared;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class AccountCreatedPage extends CommonShared {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public WebElement accountCreatedText = driver.findElement(By.xpath("//div/h2/b"));
    private WebElement continueButton = driver.findElement(By.linkText("Continue"));


    public HomePage clickOnContinueButton() {

        clickButton(continueButton);
        return new HomePage(driver);

    }




}
