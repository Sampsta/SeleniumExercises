import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	static WebDriver driver;
	static Wait<WebDriver> wait;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.get("C:\\Users\\Administra"
				+ "tor\\Desktop\\HTML\\DragAndDrop.html");
		Actions builder = new Actions(driver);
		boolean result = true;
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		if(drag != null){
			System.out.println("Load Success");
			System.out.println("draggable's location is: " +drag.getLocation());
			System.out.println("droppable's location is: " +drop.getLocation());
		}else{
			System.out.println("Load Fail");
		}
		
			try{
				builder.dragAndDrop(drag, drop).release(drop).perform();
			}catch(Exception e){
				System.out.println("Failed To Drag and Drop");
				result = false;
			}finally{
				System.out.println("draggable's location is: " +drag.getLocation());
				System.out.println("droppable's location is: " +drop.getLocation());
				System.out.println("reset draggable's location");
				builder.clickAndHold(drag).moveByOffset(-163, -25).release().perform();
				System.out.println("draggable's location is: " +drag.getLocation());
				//driver.close();
			}
		
		
		if(result){
			System.out.println("---Passed---");
		}else{
			System.out.println("---Failed---");
		}
	}
}
