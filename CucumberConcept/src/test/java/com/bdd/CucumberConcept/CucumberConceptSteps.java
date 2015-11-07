package com.bdd.CucumberConcept;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberConceptSteps {
	@Given("^I navigated to the zoo website$")
	public void shouldNavigateToZoo() throws Throwable {
		System.out.println("executed the navigate to zoo method");
	}

	@When("^I click on the adoption link$")
	public void shouldClickOnAdoption() throws Throwable {
		System.out.println("executed the click on adoption method");
	}

	@Then("^I check to see that no animals are available$")
	public void checkAnimalStringVisible() throws Throwable {
		System.out.println("check no animal string was visible");
	}
}
