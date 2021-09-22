package Pack1;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MultiWindowTest {
	WebDriver driver;

	@Test
	public void HandleWindows() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");

		// permet de garder le handle de la fenetre
		String mainHandle = driver.getWindowHandle();
		System.out.println(mainHandle);

		// Va chercher un element de type lien par le texte du lien
		WebElement link = driver.findElement(By.linkText("Open a popup window"));
		link.click();

		// Va chercher toute les handle des fenetre ouverte
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();

		// Nous allons itérer toute les handle des fenetres
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// String para1 = driver.findElement(By.id("para1")).getText();
		// System.out.println(para1);

		Thread.sleep(3000);
	}
	
	@Test
	public void HandleWindows2() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");

		// permet de garder le handle de la fenetre
		String mainHandle = driver.getWindowHandle();
		System.out.println(mainHandle);

		// Va chercher un element de type lien par le texte du lien
		WebElement link = driver.findElement(By.linkText("Open a popup window"));
		link.click();

		// Va chercher toute les handle des fenetre ouverte
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		String mainWindow = itr.next();
		String childWindow = itr.next();

		// Fait un switch pour aller dans la fenetre enfant
		driver.switchTo().window(childWindow);
		String para1 = driver.findElement(By.id("para1")).getText();
		System.out.println(para1);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());	
		
		// Retour vers la page princiale
		driver.switchTo().window(mainWindow);		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());	

		//Thread.sleep(1000);
	}

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		// driver.close();
		driver.quit();
	}

}
