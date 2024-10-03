package Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTests {

    public static WebDriver driver;

    public static void setup(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://app.respond.io/user/login");
    }

    public static void tearDown() {
        driver.quit();
    }
}