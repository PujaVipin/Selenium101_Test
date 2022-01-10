import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario3 {

	WebDriver driver;
	@Test(priority=1)
	void OpenBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/span[1]")).click();
		System.out.println("The popup notification for cookies has been handled successfully.");
		
		
	}
	
	@Test(priority=2)
	void InputFormSubmit()
	{
		
		WebElement inputForm=driver.findElement(By.xpath("//a[normalize-space()='Input Form Submit']"));
		inputForm.click();
	}
	
	@Test(priority=3)
	void ValidationOfErrorMessage()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualErrorMessage = driver.findElement(By.id("name")).getAttribute("validationMessage");
		System.out.println("The Error Message captured is :" +actualErrorMessage);
		String assertedErrorMessage="Please fill in the fields";
		System.out.println("The Assert Error Message is :" +assertedErrorMessage);
		Assert.assertEquals(actualErrorMessage,assertedErrorMessage,"The Error message appears different");
		
	}

	@Test(priority=3)
	void FillDataSubmit() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Pooja Anilkumar");
		driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("pujaa22@gmail.com");
		driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("vipin123");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("WIPRO TECHNOLOGIES");
		driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("www.wipro.com");
		WebElement countryDropdown=driver.findElement(By.xpath("//select[@name='country']"));
		Select country=new Select(countryDropdown);
		country.selectByVisibleText("United States");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("Abudhabi");
		driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("Al Hilal Tower, Najda street");
		driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("Near Doha Bank");
		driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Abudhabi");
		driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("00971");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}
	@Test(priority=5)
	void SuccessMessage()
	{
		
	String messageValidation=driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
	if(messageValidation.contains(messageValidation))
	{
		System.out.println("Success Message is Displayed as expected");
	
	}

	}
	
	@Test(priority=6)
	void QuitPage()
	{
		
	driver.quit();

	}
	
}
