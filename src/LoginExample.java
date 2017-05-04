import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginExample {

	static WebDriver driver;
	static Wait<WebDriver> wait;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://www.facebook.com/");
		try{
		WebElement username = driver.findElement(By.name("email"));
			username.sendKeys("jobloggs@hotmail.com");
		WebElement password = driver.findElement(By.name("pass"));
			password.sendKeys("genericPassword");
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
			loginButton.submit();
		wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					boolean results;
					System.out.println("Searching ...");
					if(webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div")) != null){
						results = true;
						System.out.println("---Passed---");
					}else{
						results = false;
						System.out.println("---Failed---");
						}
					return results;
				}
			});
		}
		catch(TimeoutException e){
			System.out.println(e);
			
		}
		finally{
			driver.close();
		}
		
	}
	

}
