package indeedau;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Indeedauto {
    public static void main(String[] args) throws InterruptedException {
        // Ensure correct ChromeDriver is installed
        WebDriverManager.chromedriver().setup();

        // Configure Chrome to use your existing profile
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\ronis\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default"); 
        options.addArguments("--disable-geolocation"); // Disable geolocation prompts
        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Implicit wait (Global wait for element presence)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit wait object (for specific elements)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Navigate to Indeed (should open with logged-in session)
            driver.get("https://www.naukri.com/mnjuser/homepage");
            System.out.println("Test Passed: Successfully opened Indeed with logged-in session.");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        // Do not quit driver to keep session open
        WebElement element = driver.findElement(By.className("nI-gNb-sb__placeholder"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//input[@placeholder='Enter keyword / designation / companies']"));
        element1.sendKeys("Physics Lecturer, Automation Engineer, QA Engineer, QA Tester, QA Analyst, Software Engineer, Software Developer, Software Tester, Software Automation Engineer, Software Automation Tester");
        WebElement element3 = driver.findElement(By.xpath("//input[@placeholder='Enter location']"));
        element3.sendKeys("Bengaluru");
        
        WebElement element4 = driver.findElement(By.xpath("//span[@class='ni-gnb-icn ni-gnb-icn-expand-more']"));
        element4.click();
        
        WebElement element5 = driver.findElement(By.xpath("//span[@class='nI-gNb-sb__expDD-item-sl']"));
        element5.click();
        //WebElement element1 = driver.findElement(By.xpath("//input[@id='text-input-where']"));
        //element1.sendKeys("");
        WebElement element2 = driver.findElement(By.xpath("//span[@class='ni-gnb-icn ni-gnb-icn-search']"));
        element2.click();
        
        Scrappingauto scrapping = new Scrappingauto(driver);
        scrapping.scrap();
        
        
    }
}
