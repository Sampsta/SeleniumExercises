import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesExample {

	static WebDriver driver;
	static Wait<WebDriver> wait;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://www.netflix.com/gb/login");
		Actions action = new Actions(driver);
		
		WebElement username = driver.findElement(By.name("email"));
				if(username != null){
					System.out.println("Load Success");
				}else{
					System.out.println("Load Fail");
				}
			username.sendKeys("ds377@kent.ac.uk");
		WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("Wincity1992");
		WebElement loginButton = driver.findElement(By.className("login-button"));
			loginButton.submit();
		WebElement profile = driver.findElement(By.className("profile-icon"));
			profile.click();
		System.out.println("logged in");
//		WebElement avatar = driver.findElement(By.className("avatar-wrapper"));
//		avatar.click();
		WebElement logoutAction = driver.findElement(By.className("account-dropdown-button"));
		logoutAction.click();
		logoutAction.findElements(By.linkText("Sign out of Netflix")); 
		logoutAction.click();
		//("sub-menu-link"));
		//WebElement link = driver.findElement(By.xpath("//*[@id=\"hdPinTarget\"]/div/div[3]/div/div[2]/ul[3]/li[3]/a"));
		try{
		
		File f = new File("browser.data");
		//f.delete();
		f.createNewFile();
		BufferedWriter bos = new BufferedWriter(new FileWriter(f));
		
			for(Cookie ck : driver.manage().getCookies()){
				bos.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()
				+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
				bos.newLine();
			}
			bos.close();
			driver.quit();
			
			driver = new ChromeDriver();
			driver.get("http://www.netflix.com/gb/login");
			File f2 = new File("browser.data");
			BufferedReader br = new BufferedReader(new FileReader(f2));
			String line;
			while((line=br.readLine()) !=null){
				StringTokenizer str = new StringTokenizer(line, ";");
				while(str.hasMoreTokens()){
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;
							
							if(!(dt=str.nextToken()).equals("null")){
								expiry = new Date(dt);
							}
						boolean isSecure = new Boolean(str.nextToken()).booleanValue();
						Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
						driver.manage().addCookie(ck);
						System.out.println(ck.getName());
				}
			}br.close();
		}catch(TimeoutException e){
			System.out.println("check console for specific error, ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
