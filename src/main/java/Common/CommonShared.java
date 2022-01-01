package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class CommonShared {
    public WebDriver driver;

    public CommonShared(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickButton(WebElement button) {
        button.click();
    }

    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }


    public void selectFromDropdownBySelect(WebElement element, String option) {
        Select dropDownElement = new Select(element);
        dropDownElement.selectByVisibleText(option);
    }

    public Select findDropDownElement(WebElement element) {
        return new Select(element);
    }

    public List<String> getSelectedOptions(WebElement element) {
        List<WebElement> selectedElements = findDropDownElement(element).getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void hoverOnElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }

    public void uploadFile(WebElement fileUploader, WebElement uploadBtn, String filePath) {
        fileUploader.sendKeys(filePath);
        uploadBtn.click();
    }

    public void scrollToElement(WebElement element) {
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public String getElementText(WebElement element){
        return element.getText();
    }

}
