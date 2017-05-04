import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesExample {
	
static WebDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Administrator\\Desktop\\HTML\\Frames.html");
		boolean result = true;
		//Actions action = new Actions(driver);
		
		
		try{
		driver.switchTo().frame(0);
		WebElement txt = driver.findElement(By.name("1"));
		if(txt != null){
			System.out.println("Load Success");
		}else{
			System.out.println("Load Fail");
		}
		txt.sendKeys("I'm frame one");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		txt = driver.findElement(By.name("2"));
		txt.sendKeys("I'm frame two");
		}catch(Exception e){
			System.out.println("tried removeing the action?");
			result = false;
		}

		
		if(result){
			System.out.println("success");
		}else{
			System.out.println("failed");
		}
	}
}
