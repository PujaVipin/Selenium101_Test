import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario2 {

	public static void main(String[] args) {
		
		//Opening the Lambda Test's Selenium Playground using Chrome Driver.
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
		
		//Maximizing the window.
		driver.manage().window().maximize();
		
		//Handling the cookie pop-up notification. 
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/span[1]")).click();
		System.out.println("The popup notification for cookies has been handled successfully.");
		
		//clicking “Drag & Drop Sliders” under “Progress Bars & Sliders”. 
		driver.findElement(By.xpath("//p[normalize-space()='Progress Bar & Sliders']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Drag & Drop Sliders']")).click();
		
		//Selecting the slider and dragging to 95.
		WebElement defaultSlider=driver.findElement(By.xpath("//div[@class='sp__range sp__range-success']"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(defaultSlider, 98, 0).perform();
	
		//Validating whether the range value showing is 95.
		WebElement rangeValue=driver.findElement(By.id("rangeSuccess"));
		System.out.println("The Range value changes to " +rangeValue.getAttribute("value"));
		boolean validateValue=driver.findElement(By.id("rangeSuccess")).isDisplayed();
		
		if(validateValue)
		{
			System.out.println("Validated that the Range Value displayed is 95");			
		}else 
		{
			System.out.println("Validated that the Range Value displayed is not 95");
		}
		
		//Closing the browser
		driver.quit();
		
		
		
	
		
	}

}