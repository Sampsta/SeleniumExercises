import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowExample {

	static WebDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Administrator\\Desktop\\HTML\\Window.html");
		boolean results = true;
		String window1 = driver.getWindowHandle();
//		if(window1 != null){
//			System.out.println("Load Success");
//		}else{
//			System.out.println("Load Fail");
//		}
		
		try{
			WebElement link = driver.findElement(By.linkText("Google Search"));
			System.out.println("First handle is "+window1);
			link.click();
		
		
		driver.switchTo().window(window1);
		}catch(Exception e){
		System.out.println("something went wrong");
			results = false;
		}finally{
			String window2 = driver.getWindowHandle();
			System.out.println("Second handle is "+window2);
			System.out.println("# handles so far: " +driver.getWindowHandles().size());
			driver.switchTo().window(window1);
		}
		
	
		if(results){
			System.out.println("success");
		}else{
			System.out.println("failed");
		}
	}
	
}
