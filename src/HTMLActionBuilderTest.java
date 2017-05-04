import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HTMLActionBuilderTest {

	static WebDriver driver;
	static Wait<WebDriver> wait;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.get("C:\\Users\\Administrator\\Desktop\\HTML\\Sortable.html");
		Actions builder = new Actions(driver);
		boolean result = true;
		
		WebElement one = driver.findElement(By.name("one"));
		WebElement two = driver.findElement(By.name("two"));
		WebElement three = driver.findElement(By.name("three"));
//		WebElement four = driver.findElement(By.name("four"));
//		WebElement five = driver.findElement(By.name("five"));
//		WebElement six = driver.findElement(By.name("six"));
//		WebElement seven = driver.findElement(By.name("seven"));
//		WebElement eight = driver.findElement(By.name("eight"));
//		WebElement nine = driver.findElement(By.name("nine"));
//		WebElement ten = driver.findElement(By.name("ten"));
//		WebElement eleven = driver.findElement(By.name("eleven"));
//		WebElement twelve = driver.findElement(By.name("twelve"));
		
		
		if(one != null){
			System.out.println("Load Success");
			System.out.println("Three's location is: " +three.getLocation());
			System.out.println("Two's location is: " +two.getLocation());
		}else{
			System.out.println("Load Fail");
		}
		
			try{
				//builder.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0).release().perform();
				builder.clickAndHold(two).release(three).perform();
			}
				catch(Exception e){
					System.out.println("Failed To Drag and Drop");
					result = false;
				}
					finally{
						System.out.println("------------");
						System.out.println("Three's location is: " +three.getLocation());
						System.out.println("Two's location is: " +two.getLocation());
						driver.close();
					}
			
			if(result){
				System.out.println("---Passed---");
			}else{
				System.out.println("---Failed---");
			}
	}
	
//	public void moveIt(){
//		Actions builder2 = new Actions(driver);
//		builder2.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0).release().perform();
//	}
}
