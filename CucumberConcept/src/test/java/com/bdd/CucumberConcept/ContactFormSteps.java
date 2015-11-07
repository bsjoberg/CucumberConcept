package com.bdd.CucumberConcept;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactFormSteps {
	WebDriver driver = null;
	
	public ContactFormSteps() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dad\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("^I am on simple form website$")
	public void navigateToSimpleFormWebsite() throws Throwable {
		driver.navigate().to("http://parsleyjs.org/doc/examples/simple.html");
	}

	@When("^Populate contact form$")
	public void shouldPopulateForm() throws Throwable {
		driver.findElement(By.name("fullname")).sendKeys("Brian");
		driver.findElement(By.name("email")).sendKeys("brian@yahoo.com");	
		driver.findElement(By.id("heard")).sendKeys("p");
		
		java.util.List<WebElement> buttons = driver.findElements(By.name("gender"));
		buttons.get(0).click();
	
		driver.findElement(By.className("btn-default")).click();
	}

	@Then("^I should see everything is ok$")
	public void testValidateMessage() throws Throwable {
		String message = driver.findElement(By.className("bs-callout-info")).getText();
		Assert.assertTrue(message.contains("Yay!"));
		driver.quit();
	}
	
	@When("^Populate invalid data in contact form$")
	public void populateInvalidForm() throws Throwable {
		// Don't populate anything.
		driver.findElement(By.className("btn-default")).click();
	}

	@Then("^I should see error$")
	public void testInvalidMessage() throws Throwable {
		String message = driver.findElement(By.className("bs-callout-warning")).getText();
		Assert.assertTrue(message.contains("Oh snap"));
		driver.quit();
	}
}
