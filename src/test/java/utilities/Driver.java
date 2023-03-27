package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    private static String Browser = "browser";

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (driver == null) {
            if (Browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver(options);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else if (Browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else
                System.out.println("Invalid");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            return driver;
        } else {
            return driver;
        }

    }

    public static void quitBrowser(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
