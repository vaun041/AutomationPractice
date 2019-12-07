package glue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Functions1 {
	public static WebDriver driver;
	
	@Before public void setup() {
		System.out.println("Starting the test");
	}
	
	@Given("^User reaches on the homepage$")
	public void user_reaches_on_the_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","D:/jar files/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
	}

	@When("^User goes to the login page$")
	public void user_goes_to_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Sign in")).click();
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
	}

	@Then("^I validate the title$")
	public void i_validate_the_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String exp_message = "My account - My Store";
    	String actual = driver.getTitle();
        Assert.assertEquals(exp_message, actual);  
	}
	@After public void quit() {
		System.out.println("Ending the test");
//		driver.quit(); 
	}
}
