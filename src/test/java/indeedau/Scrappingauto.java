//Naukri April 5

package indeedau;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrappingauto {

	private  WebDriver driver;
	private WebDriverWait wait;
	public Scrappingauto(WebDriver driver) {
		  this.driver = driver;
		  this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void scrap() throws InterruptedException {
		System.out.println("Scraping data from Indeed...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement sortby = driver.findElement(By.xpath("//button[@id='filter-sort']"));
		sortby.click();
		
		// Wait for the dropdown to be visible
		WebElement dateoption = driver.findElement(By.xpath("//a[@data-id='filter-sort-f']"));
		dateoption.click();
		
		
		//List<WebElement> jobcards = driver.findElements(By.xpath("//div[@class='styles_job-listing-container__OCfZC']"));
		
		
		List<WebElement> jobcards = driver.findElements(By.xpath("//div[@class='srp-jobtuple-wrapper']")); 	
		wait.until(ExpectedConditions.visibilityOfAllElements(jobcards));
		
		System.out.println("Number of job cards: " + jobcards.size());
		for (WebElement jobcard1:jobcards) {
			jobcard1.click();
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			String originalwindow = driver.getWindowHandle();
			
		    Set<String> allwindows = driver.getWindowHandles();
			for (String window : allwindows) {
				if (!window.equals(originalwindow)) {
					driver.switchTo().window(window);
					// Perform actions in the new window
					System.out.println("Switched to new window: " + driver.getTitle());
					try {
					WebElement applybutton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Apply']")));
					applybutton.click();
					}
					catch (Exception e) {
						System.out.println("Apply button not found or not clickable.");
					}
					driver.close();
					driver.switchTo().window(originalwindow);
					
				  
				}
			}
		
			
		}
		
		WebElement pagenum = driver.findElement(By.xpath("//div[@class='styles_pages__v1rAK']//a[contains(.,'2')]"));
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pagenum);
		
		Thread.sleep(2000);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(pagenum));
		pagenum.click();
	} catch (Exception e) {
		System.out.println("Page number not clickable.");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", pagenum);
	}
		
		//This is my next step after page 2 !! logic defect might be here because i donno ;
		
		
		
		
		int totalpages =10;
		for (int i=1 ; i<=totalpages; i++) {
			Thread.sleep(10000);
			
		 
			
			List<WebElement> jobcards2 = driver.findElements(By.xpath("//div[@class='srp-jobtuple-wrapper']")); 	
			wait.until(ExpectedConditions.visibilityOfAllElements(jobcards2));
			
			System.out.println("Number of job cards: " + jobcards2.size());
			for (WebElement jobcard1:jobcards2) {
				jobcard1.click();
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
				String originalwindow = driver.getWindowHandle();
				
			    Set<String> allwindows = driver.getWindowHandles();
				for (String window : allwindows) {
					if (!window.equals(originalwindow)) {
						driver.switchTo().window(window);
						// Perform actions in the new window
						System.out.println("Switched to new window: " + driver.getTitle());
						try {
						WebElement applybutton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Apply']")));
						applybutton.click();
						}
						catch (Exception e) {
							System.out.println("Apply button not found or not clickable.");
						}
						driver.close();
						driver.switchTo().window(originalwindow);
						
					  
					}
				}
			
				
			}
			System.out.println("Scraping page " + i);
			if(i<totalpages) {
				

				WebElement pagenum1 = driver.findElement(By.xpath("//div[@class='styles_pages__v1rAK']//a[contains(.,'"+(i+1)+"')]"));
				
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pagenum1);
				
				Thread.sleep(2000);
				try {
				wait.until(ExpectedConditions.elementToBeClickable(pagenum1));
				pagenum1.click();
			} catch (Exception e) {
				System.out.println("Page number not clickable.");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", pagenum1);
			}
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}
	
}
	
	
	
		
		
	


