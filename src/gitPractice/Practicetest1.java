package gitPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;



public class Practicetest1 {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[value='radio2']")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		//List<WebElement> countries= driver.findElements(By.xpath("//ul[contains(@class,'ui-menu')]/li"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> countries = wait.until(
		        ExpectedConditions.visibilityOfAllElementsLocatedBy(
		                By.xpath("//ul[contains(@class,'ui-menu')]/li")
		        )
		);
		
		for(WebElement list:countries)
		{
	System.out.print(list.getText());
			if(list.getText().equals("India"))
			{
				list.click();
		        break;
			}
		}
		
	    driver.findElement(By.id("dropdown-class-example")).click();
		Select select = new Select( driver.findElement(By.id("dropdown-class-example")));
        select.selectByValue("option1");
//        ------------------
        driver.findElement(By.id("checkBoxOption1")).click();
//        driver.findElement(By.id("openwindow")).click();
//        driver.switchTo().newWindow((WindowType.WINDOW));
//        driver.navigate().to("https://www.qaclickacademy.com/");
//        driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
        
//        -------------------
        
        driver.findElement(By.name("enter-name")).sendKeys("Vikas");
        driver.findElement(By.id("alertbtn")).click();
       String alertmsg = driver.switchTo().alert().getText();
       System.out.print(alertmsg);
       driver.switchTo().alert().accept();
       
//       --------
       
//       driver.findElement(By.id("displayed-text")).isDisplayed();
       
//       -----------------
       
//       Actions action = new Actions(driver);
//       
//       WebElement mouse = driver.findElement(By.id("mousehover"));
//       action.scrollToElement(mouse).perform();
//       action.moveToElement(mouse).perform();
//       driver.findElement(By.xpath("//a[text()='Top']")).click();
       
//       --------------
        driver.switchTo().frame("iframe-name");
        driver.findElement(By.xpath("//a[text()='JOIN NOW']")).click();
        
	}


}
