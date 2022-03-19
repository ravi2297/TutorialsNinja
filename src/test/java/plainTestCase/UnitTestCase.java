package plainTestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnitTestCase {
public static WebDriver driver;
	
	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\TutorialsNinja\\TutorialsNinja\\src\\test\\resources\\DRIVERS\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[text()='My Account']")).click();
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		
		driver.findElement(By.xpath("#input-email")).sendKeys("ravibhalerao9970@gmail.com");
		driver.findElement(By.xpath("input-password")).sendKeys("ravikiran");
		
		driver.findElement(By.cssSelector("[value='Login']")).click();
		
		String givenText="Your Store";
		String actualText=driver.findElement(By.xpath("//*[text()='Your Store']")).getText();
		if (givenText.equalsIgnoreCase(actualText))
		{
			System.out.println("Test case has been Passed.");
		}
		else
		{
			System.out.println("Test case has been Failed.");
		}
		driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);		
		
		
		
	}
	
}
