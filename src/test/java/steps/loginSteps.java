package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSteps {

	public static WebDriver driver;
	
	@Given("User should navigate to the application")
	public void userShouldNavigate() {
		System.setProperty("webdriver.chrome.driver","./Drivers/Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.get("https://bookcart.azurewebsites.net/");
	}
	
	@Given("User clicks on the login link")
	public void userClicksOnTheLoginLink() {
	    driver.findElement(By.xpath("//span[contains(text(),' Login ')]")).click();
	    		}

	@Given("User enter the username as Ortoni")
	public void userEnterTheUsernameAsOrtoni() {
	    driver.findElement(By.id("mat-input-0")).sendKeys("bkcart");
	}

	@Given("User enter the password as Ortoni")
	public void userEnterThePasswordAsOrtoni() {
	driver.findElement(By.id("mat-input-1")).sendKeys("Bkcart45");
	}

	@When("User click the login button")
	public void userClickTheLoginButton() throws InterruptedException {
		Thread.sleep(3000);
	  driver.findElement(By.xpath("(//span[contains(text(),'Login')])[2]")).click();
	}

	@Then("login should be successful")
	public void loginShouldBeSuccessful() {
	String login =   driver.findElement(By.xpath("(//span[@class='mdc-button__label']/child::span)[1]")).getText();
	System.out.println(login);
	}

}
