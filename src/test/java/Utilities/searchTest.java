package Utilities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.DriverSetup;

import org.openqa.selenium.interactions.Actions;

public class searchTest extends DriverSetup{
	@Test
	public void search() throws InterruptedException {
		
		WebElement search = driver.findElement(By.xpath("(//input[@id='manga-search'])[1]"));
		search.click();
	    search.sendKeys("Naruto");
	    WebElement searchButton= driver.findElement(By.xpath("//button[normalize-space()='Search']"));
	    searchButton.click();
	    
	    WebElement description = driver.findElement(By.xpath("(//h3[normalize-space()='Naruto'])[1]"));
        assertEquals(description.getText(), "Naruto");
	    
        
        
        
	}
	
}	