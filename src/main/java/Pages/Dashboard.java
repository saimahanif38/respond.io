package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard extends BaseTests {

    private final WebDriver driver;
    WebDriverWait wait;
    
    private final By workflowLocator = By.className("icon-custom-workflow");

    private final By addWorkFlowButton = By.xpath("//*[@id=\"radix-vue-dropdown-menu-trigger-1\"]/button/span[3]/span");
    
    private final By addTemplateButton = By.xpath("//*[@id=\"root\"]/div[1]/div/div/main/div/div[2]/div/div/div[2]/div[2]/div/div[6]/div/div[2]/div[2]/button");
    
    private final By useTemplateButton = By.xpath("//*[@id=\"root\"]/div[1]/div/div/main/div/div[2]/div/div[2]/div[1]/div[1]/button");
   
    private final By publishButton = By.xpath("//*[@id=\"root\"]/div[1]/div/div/main/div/div[2]/div/div/div/div[1]/header/div/div[3]/button[5]");
   
    private final By successMessageText = By.xpath("//*[@id=\"root\"]/div[1]/div/section/ol/li/div/div/div/div/div[1]");
    
    public Dashboard(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public String getCurrentURL() throws InterruptedException
    {
    	Thread.sleep(3000);
    	return driver.getCurrentUrl();
    }

    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Wait for an element" + locator.toString());
            e.printStackTrace();
        }
    }
    
    public void createWorkflow()
    {
    	waitForElementPresent(workflowLocator);
    	driver.findElement(workflowLocator).click();
    	
    	waitForElementPresent(addWorkFlowButton);
    	driver.findElement(addWorkFlowButton).click();
    	
    	waitForElementPresent(useTemplateButton);
    	driver.findElement(useTemplateButton).click();
    	
    	waitForElementPresent(publishButton);
    	driver.findElement(publishButton).click();	
    }
    
    public String validateSuccessMessageAppeared() 
    {
    	waitForElementPresent(successMessageText);
    	return driver.findElement(successMessageText).getText();
    }
    
}