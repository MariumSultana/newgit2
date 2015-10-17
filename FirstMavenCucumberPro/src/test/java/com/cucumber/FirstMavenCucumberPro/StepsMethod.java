package com.cucumber.FirstMavenCucumberPro;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsMethod {
	
	@Given("^my first step$")
	public void first() throws Throwable {
		System.out.println("my first step");
	  
	}

	@When("^my second step$")
	public void second() throws Throwable {
		System.out.println("my second step");
	}

	@Then("^my third step$")
	public void third() throws Throwable {
		System.out.println("my third step");
	}

}
