package glue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Functions {
	public static WebDriver driver;
	@Given("^user is  on homepage$")
	public void user_is_on_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","D:/jar files/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Sign in")).click();
	}

	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String exp_message = "My account - My Store";
    	String actual = driver.getTitle();
        Assert.assertEquals(exp_message, actual);
        driver.quit();  
	}
}
