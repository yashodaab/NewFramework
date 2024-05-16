package crm.generic.webDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	//1) Implicitly wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//2) Expliitly wait
	public void waitForElementPresent(WebDriver driver, WebElement Element) {
		WebDriverWait wait =  new  WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	//3) Switch to new window(child browser tab)
	public void switchNewBrowserTab(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
		    String windowID= it.next();
			driver.switchTo().window(windowID);
			
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("partialURL")) {
				break;
			}
		}
		
	}
	
	//4) Switch to new window(child browser tab)
		public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			
			while(it.hasNext()) {
			    String windowID= it.next();
				driver.switchTo().window(windowID);
				
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains("partialTitle")) {
					break;
				}
			}
			
		}
		
		// 6) Switch to Frame based on index
		public void switchToFrame(WebDriver driver, int index) {
					driver.switchTo().frame(index);
				}
		
		// 7) Switch to Frame based on nameID
		public void switchToFrame(WebDriver driver, String nameID) {
				driver.switchTo().frame(nameID);
						}
		
		// 8) Switch to Frame based on element
		public void switchToFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
						}
		
		//9) switch to Alert and accept
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		//10) switch to Alert and cancel
		public void switchToAlertAndCancel(WebDriver driver) {
					driver.switchTo().alert().dismiss();
				}
		
		//11) Dropdown
		public void select(WebElement element , String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		//12)
		public void select(WebElement element , int Index) {
			Select sel = new Select(element);
			sel.selectByIndex(Index);
		}
		
		//13) Mouse movement
		public void mouseMoveOnElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		//14)
		public void doubleClick(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		
}
