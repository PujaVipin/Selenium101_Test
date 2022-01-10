import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario1 {

	public static void main(String[] args) {
		//Opening the Lambda Test's Selenium Playground using Chrome Driver		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		
		//Popup Notification Handling
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/span[1]")).click();
		System.out.println("The popup notification for cookies has been handled successfully.");
		
		//Click "Simple Form Demo" under Input Forms
		WebElement ClickInputForm=driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']"));
		ClickInputForm.click();
		
		//Validating that the url contains "simple-form-demo"
		if (driver.getCurrentUrl().contains("simple-form-demo"))
		{
			System.out.println("The Url contains : simple-form-demo");
		}
		
		//Create a variable for a string value E.g: “Welcome to LambdaTest” 
		WebElement textVariable= driver.findElement(By.xpath("//input[@id='user-message']"));
		String stringValue= "Welcome to Lambda Test";
		textVariable.sendKeys(stringValue);
		
		//Entering the string value and clicking the 'Get Checked Value'
		WebElement clickValue= driver.findElement(By.xpath("//button[@id='showInput']"));
		clickValue.click();
		
		//Validate whether the same message is displayed
		WebElement textValidation=driver.findElement(By.xpath("//p[@id='message']"));
		String expectedText= stringValue;
		String actualText=textValidation.getText();
		
		if(actualText.equals(expectedText))
		{
			System.out.println("The message displayed is validated.");
			
		}
		//Closing the browser
		driver.quit();
	}

}
