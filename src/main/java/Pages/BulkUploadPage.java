package Pages;
import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BulkUploadPage extends BaseTests {

    private WebDriver driver;

    private By errorMessage = By.className("alert-danger");

    private By inputField = By.id("undefined");

    private By bck = By.className("back-menu");

    private By uploadbutton = By.className("btn-upload-submit");

    private By removeFile = By.className("onremovefile");

    private Boolean isPresent;

    private WebDriverWait wait;

    public BulkUploadPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 120);
    }

    public void clickuploadbutton(){
        driver.findElement(uploadbutton).click();
    }

    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickuploadbutton();
        waitForElementPresent(bck);
    }

    public String getErrorMessage(){
        waitForElementPresent(errorMessage);
        isPresent = driver.findElements(By.xpath("//div[contains(text(),'Show more')]")).size() > 0;
        if(isPresent) driver.findElement(By.xpath("//div[contains(text(),'Show more')]")).click();
        return driver.findElement(errorMessage).getText();
    }

    public void clickRemoveFileButton(){
        waitForElementPresent(removeFile);
        driver.findElement(removeFile).click();
    }

    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Wait for an element" + locator.toString());
            e.printStackTrace();

        }
    }


}
