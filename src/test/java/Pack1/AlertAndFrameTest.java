package Pack1;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AlertAndFrameTest {
	WebDriver driver;

	@Test
	public void handleAlerts() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");

		driver.findElement(By.id("alert1")).click();
		//Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String textAlert = alert.getText();
		System.out.println("Le texte de l'alerte: " + textAlert);	
		alert.accept();
		driver.switchTo().defaultContent();
	}

	@Test
	public void handleIFrame() throws Exception {
		driver.get("https://www.dezlearn.com/iframe-example/");
		WebElement frame1 = driver.findElement(By.id("iframe1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("u_5_6")).click();
		driver.switchTo().defaultContent();
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
