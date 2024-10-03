package Pages;
import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseTests {

    WebDriverWait wait;

    @FindBy(name="field_2")
    WebElement email;

    @FindBy(name="field_3")
    WebElement userpass;

    private final By loginButtonLocator = By.xpath("//button[3]");

    private final By errorMessageLocator = By.xpath("//*[@id=\"alert\"]/div");
    
    private final By heading = By.xpath("//*[@id=\"authContainer\"]/div[1]/div[2]/div/div/div[1]/span");


    public LoginPage()
    {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void onLoginPage(){
        waitForElementPresent(loginButtonLocator);
    }

    public String getError()
    {
    	waitForElementPresent(errorMessageLocator);
        return driver.findElement(errorMessageLocator).getText();
    }
    
    public String getHeading()
    {
        return driver.findElement(heading).getText();
    }

    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Wait for an element" + locator.toString());
            e.printStackTrace();

        }
    }

    public void setUsernameAndPassword(String username, String password)
    {
        waitForElementPresent(loginButtonLocator);
        email.clear();
        userpass.clear();
        email.sendKeys(username);
        userpass.sendKeys(password);
    }
    
    public Dashboard getDriver() {
    	return new Dashboard(driver);
    }

    public Dashboard clickLoginbutton()
    {
    	// Define a WebDriverWait
    	 WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait until the button is clickable
         WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
    	 driver.findElement(loginButtonLocator).click();
         return new Dashboard(driver);
    }
}
