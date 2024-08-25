package Utilities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class DriverSetup {
	public WebDriver driver;
    private static final Logger logger = Logger.getLogger(DriverSetup.class.getName());

	@BeforeSuite
	public void setup() throws IOException {
	    // Setup logging configuration
	    FileHandler fileHandler = new FileHandler("test_log.log", true);
	    fileHandler.setLevel(Level.INFO);
	    fileHandler.setFormatter(new SimpleFormatter());
	    logger.addHandler(fileHandler);
	    logger.setLevel(Level.INFO);
	    
	    
	}
	
	@Test (priority = 0)
public void testcase1() throws InterruptedException {
	     logger.info("Testing started....");
	     // Step 1: Launch Browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//logger.info("Browser Launch successfully");
		
		//Step 2: Open URL
		driver.get("https://myalice-automation-test.netlify.app/");
		assertEquals(driver.getTitle(), "React App");
		logger.info("Login Page displayed");
	
		//Step 3: Enter Username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("testuser");
		Thread.sleep(2000);
		
		
		//Step 4: Enter Password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password");
		Thread.sleep(2000);
		
		//Step 5: Click Login button
		WebElement loginbutton = driver.findElement(By.id("login-btn"));
		loginbutton.click();
		Thread.sleep(2000);
		
		// verify login or not by check URL
		String expected_url = "https://myalice-automation-test.netlify.app/";
	    String actual_url = driver.getCurrentUrl();
	    
	    if (expected_url.equals(actual_url)) {
	    	logger.info("Test Passed. Login successful.user is redirected to the manga search page. ");
	    	// capture screenshot
	       // driver.get_screenshot_as_file(screenshotFilePath+"\\login_passed_test_passed.png");
	    } else {
	    	logger.severe("Test Failed. Login failed.");
	    }
	    
	    logger.info("Login_testCase1_ execution completed...");
	}
		@Test (priority =  2)
	    public void testcase2() throws InterruptedException {
	    	
	    	logger.info("Test Case 2 Execution started...");
		     // Step : Manga Search and Display
	    	// Step: Click on search field
	    	WebElement search = driver.findElement(By.xpath("(//input[@id='manga-search'])[1]"));
			search.click();
		    search.sendKeys("Naruto");
		    Thread.sleep(2000);
		    
		    // Step: Click on Search Button
		    WebElement searchButton= driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		    searchButton.click();
		    
		    // Step: Display of searched item
		    
		    WebElement description = driver.findElement(By.xpath("(//h3[normalize-space()='Naruto'])[1]"));
	        assertEquals(description.getText(), "Naruto");
	        if (description.getText().equals("Naruto")) {
		    	logger.info("Test Passed. manga cards with the name Naruto are displayed.");
		    	// capture screenshot
		       // driver.get_screenshot_as_file(screenshotFilePath+"\\login_passed_test_passed.png");
		    } else {
		    	logger.severe("Test Failed. Search FIeld");
		    }
		    logger.info("Search_testCase2_ execution completed...");
	    	Thread.sleep(3000);
	    	
	    }
	   @Test (priority = 3)
	   
public void testcase3() throws InterruptedException {
	    	
	    	logger.info("Test Case 3 Execution started...");
		     // Step : Manga Search and Display
	    	// Step: Click on search field
	    	
	    	WebElement search = driver.findElement(By.xpath("(//input[@id='manga-search'])[1]"));
			search.click();
			search.clear();
		    search.sendKeys("One Piece");
		    Thread.sleep(2000);
		    
		    // Step: Click on Search Button
		    WebElement searchButton= driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		    searchButton.click();
		    
		    // Step: Display of searched item
		    
		    WebElement description = driver.findElement(By.xpath("(//h3[normalize-space()='One Piece'])[1]"));
	        assertEquals(description.getText(), "One Piece");
	        if (description.getText().equals("One Piece")) {
		    	logger.info("Test Passed. manga cards with the name One Piece are displayed.");
		    	// capture screenshot
		       // driver.get_screenshot_as_file(screenshotFilePath+"\\login_passed_test_passed.png");
		    } else {
		    	logger.severe("Test Failed. Search FIeld");
		    }
	        logger.info("Search_testCase3_ execution completed...");
	    	Thread.sleep(3000);  	
	    	
	    }
	   @Test (priority = 4)
	    
	   public void testcase4() throws InterruptedException {
	    	
	    	logger.info("Test Case 4 Execution started...");
		     // Step : Manga Search and Display
	    	// Step: Click on search field
	    	
	    	WebElement search = driver.findElement(By.xpath("(//input[@id='manga-search'])[1]"));
			search.click();
			search.clear();
		    search.sendKeys("Seven Deadly Sins");
		    Thread.sleep(2000);
		    
		    // Step: Click on Search Button
		    WebElement searchButton= driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		    searchButton.click();
		    
		    // Step: Display of searched item
		    
		    WebElement description = driver.findElement(By.xpath("(//p[@class='text-red-500'])[1]"));
	        assertEquals(description.getText(), "No manga found");
	        if (description.getText().equals("No manga found")) {
		    	logger.info("Test Passed. No manga found displayed");
		    	// capture screenshot
		       // driver.get_screenshot_as_file(screenshotFilePath+"\\login_passed_test_passed.png");
		    } else {
		    	logger.severe("Test Failed. Search FIeld");
		    }
	        driver.close();
		    logger.info("Search_testCase4_ execution completed...");
	    	Thread.sleep(3000);  	
	    	
	    }	
		@Test(priority = 1)
	   
	   
	   public void testcase5() throws InterruptedException {
	    	
	    	logger.info("Test Case 5 Execution started...");
		     
	    	
	    	WebElement search = driver.findElement(By.xpath("(//span[@class='text-blue-500 cursor-pointer'][normalize-space()='Details'])[1]"));
			search.click();
		    Thread.sleep(2000);
		    // Name
		    
		    WebElement name = driver.findElement(By.xpath("(//h3[@class='text-xl font-bold mb-2'][normalize-space()='Attack on Titan'])[2]"));
	        assertEquals(name.getText(), "Attack on Titan");
	        if (name.getText().equals("Attack on Titan")) {
		    	logger.info("Test Passed. Name correct");
		    
	        } else {
		    	logger.severe("Test Failed. Name incorrect");
		    }
		    
		    
		    // summary
		        
		    WebElement description = driver.findElement(By.xpath("//p[@class='text-gray-600 mb-4']"));
	        assertEquals(description.getText(), "Humanity fights for survival against giant humanoid Titans that have brought civilization to the brink of extinction.");
	        if (description.getText().equals("Humanity fights for survival against giant humanoid Titans that have brought civilization to the brink of extinction.")) {
		    	logger.info("Test Passed. Details showed");
		    	// capture screenshot
		       // driver.get_screenshot_as_file(screenshotFilePath+"\\login_passed_test_passed.png");
		    } else {
		    	logger.severe("Test Failed. Details not showed");
		    }
	        
	       
	        WebElement closeButton = driver.findElement(By.xpath("//button[normalize-space()='Close']"));
	       closeButton.click();
		    logger.info("Details_testCase5_ execution completed...");
	    	Thread.sleep(3000);  	
	    	
	    }	
		@AfterSuite
		public void quite() throws InterruptedException {
		 driver.close();
		}
		
	}
	
