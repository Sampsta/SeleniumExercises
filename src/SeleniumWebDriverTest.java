import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverTest {
	
	static WebDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe"); //chrome set up
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe"); //firefox set up
		
		driver = new ChromeDriver();
		
		driver.get("http://www.google.com/");
		
		boolean result = true;
		
		try{
			driver.findElement(By.name("q"));
		}
		catch(NoSuchElementException e){
			System.out.println(e);
			result = false;
		}
		finally{
			driver.close();
		}
		
		
		if(result){
			System.out.println("---Passed---");
		}else{
			System.out.println("---Failed---");
		}
	}
	
}
