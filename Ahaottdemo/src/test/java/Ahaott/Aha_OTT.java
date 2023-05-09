package Ahaott;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Aha_OTT {
//	String browserName;
	public static WebDriver driver;
//	Aha_OTT aha;
//	public  Aha_OTT(String browserName) {
//  	  this.browserName = browserName;
//
//  	  if (browserName.equalsIgnoreCase("chrome"))
//  	   driver = new ChromeDriver();
//
//  	  if (browserName.equalsIgnoreCase("firefox"))
//  	   driver = new FirefoxDriver();
//
//  	  if (browserName.equalsIgnoreCase("edge"))
//  	   driver = new EdgeDriver();
//
//  	}
//	 @BeforeClass
//	 public void setUp() {
//	  String browserName = getParameter("browser");
//	  this.aha = new Aha_OTT(browserName);
//	 }
//  
//    private String getParameter(String name) {
//	  String value = System.getProperty(name);
//	  if (value == null)
//	     throw new RuntimeException(name + " is not a parameter!");
//
//	  if (value.isEmpty())
//	    throw new RuntimeException(name + " is empty!");
//
//	  return value;
//	 }
	
	@BeforeTest
	public void launchbrowser()
	{
		String browser = System.getProperty("BROWSER");
		
		if (browser.equalsIgnoreCase("chrome"))
	  	   driver = new ChromeDriver();
	
		else if (browser.equalsIgnoreCase("firefox"))
	  	   driver = new FirefoxDriver();
	
		else if (browser.equalsIgnoreCase("edge"))
	  	   driver = new EdgeDriver();
	}
	
    @Test
	public void ahaott() throws InterruptedException  
	{

    
		// TODO Auto-generated method stub
    	driver.get("https://www.aha.video/release/new-tamil-movies");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='search-icon ng-tns-c64-0 ng-star-inserted']")).click();
		driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("siv");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//qp-plus-grid")).getShadowRoot()
		        .findElement(By.cssSelector(".card-holder:nth-child(3)"))
				.findElement(By.cssSelector("qp-res-plus-card.hydrated")).getShadowRoot()
				.findElement(By.cssSelector("qp-card-content.hydrated")).getShadowRoot()
				.findElement(By.cssSelector("qp-image.hydrated")).getShadowRoot()
			    .findElement(By.cssSelector("div > a >img")).click();
		driver.findElement(By.xpath("//button[text()=' Play Trailer ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='fullscreen']")).click();
	 WebElement e= driver.findElement(By.xpath("//div[@class='player-center']"));
	 Actions act = new Actions(driver);
	 act.moveToElement(e).build().perform();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[@class='icon icon-pause ng-star-inserted']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[@class='icon icon-play ng-star-inserted']")).click();
	 driver.findElement(By.xpath("//button[@class='button-center ng-star-inserted'][2]")).click();
	 driver.findElement(By.xpath("//i[.='fullscreen_exit']")).click();	 

		this.driver.quit();
	}

}
