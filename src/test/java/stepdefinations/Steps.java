package stepdefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class Steps {
	WebDriver driver;
	FileInputStream file;
	Properties prop;
	
	
	
	
	
	@Given("user Lanuch Chrome browser")
	public void user_lanuch_chrome_browser() throws IOException {
		FileInputStream file=new FileInputStream("C://Users//achir//OneDrive//Desktop//Gow//nopcommerce_cucumber//bro.properties");
		Properties prop=new Properties();
		prop.load(file);
		if(prop.containsKey("chrome")) {
		
		    driver=new ChromeDriver();
		}
		else if(prop.containsKey("edge ")) {
			
		    driver=new EdgeDriver();
			
		}
	}
	
	
	
	

	
	
	

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	  
	}

	@When("USer enters Email as {string} and Password as {string}")
	public void u_ser_enters_email_as_and_password_as(String uname, String password) {
		WebElement user=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		user.clear();
		user.sendKeys(uname);
		WebElement pass=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		pass.clear();
		pass.sendKeys(password);
	    
	}

	@When("Click Login")
	public void click_login() {
	    driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getTitle().equals("Dashboard / nopcommerce administration")) {
	    }
	}
	   @After
	    public void  teardown(Scenario scenario) {
	    	if(scenario.isFailed())  {
	    	TakesScreenshot ts=(TakesScreenshot) driver;
	    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	    	scenario.attach( screenshot,"img/png",scenario.getName());
	    	
	    }
	   
	    }
	    	
	    	
	    	
	    
	  
	

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a")).click();
		  
	    
	}

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}




}
