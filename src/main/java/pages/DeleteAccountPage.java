package pages;

import Common.CommonShared;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage extends CommonShared {
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    By deleteAccountBtn = By.xpath("//div[@id='deleteModal']//button[@class='btn btn-danger']");


}
