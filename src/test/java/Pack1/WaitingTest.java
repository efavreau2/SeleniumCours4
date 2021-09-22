package Pack1;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class WaitingTest {
	WebDriver driver;

	@Test
	public void staticWait() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");

		// permet de garder le handle de la fenetre
		//String mainHandle = driver.getWindowHandle();

		// Va chercher un element de type lien par le texte du lien
		driver.findElement(By.className("dropbtn")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Facebook")).click();
	}

	@Test
	public void implicitWait() throws InterruptedException {
		// Permet de faire en sorte que le driver attende de facons dynamique
		// jusqu'a ce que qu<il trouve sont element ou la fin du temps. 
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		

		driver.get("http://omayo.blogspot.com/");

		// Va chercher un element de type lien par le texte du lien
		driver.findElement(By.className("dropbtn")).click();
		driver.findElement(By.linkText("Facebook")).click();
	}
	
	@Test
	public void explicitWait() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		driver.get("http://omayo.blogspot.com/");

		// Va chercher un element de type lien par le texte du lien
		driver.findElement(By.className("dropbtn")).click();
		//driver.findElement(By.linkText("Facebook")).click();
		//WebElement lien = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
		WebElement lien = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Facebook")));		
		lien.click();
	}	

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
