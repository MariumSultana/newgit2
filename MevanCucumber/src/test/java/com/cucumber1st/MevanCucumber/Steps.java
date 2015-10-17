package com.cucumber1st.MevanCucumber;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver dr;
	String actual;
	@Given("^navigate to ehealth page$")
	public void getURL() throws Throwable {
		dr = new FirefoxDriver();
	    dr.get("https://www.ehealthinsurance.com/");
	    dr.manage().window().maximize();
	    dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	}

	@When("^click on dental plan$")
	public void linkClick() throws Throwable {
	    dr.findElement(By.xpath("//li[@id='ifp-dental']/a")).click();
	}

	@And("^find zipCode click on zip$")
	public void find_click_on()throws Throwable {
		dr.findElement(By.id("zipCode")).sendKeys("01752");
	}

	@And("^click on goBtn$")
	public void click_on ()throws Throwable {
		 dr.findElement(By.id("goBtn")).click();
	}

	@Then("^Get the text$")
	public void Get_the() throws Throwable {
	actual=	dr.findElement(By.xpath("//section[@id='census-upper']/h2")).getText();
	   
	}

	@And("^verify the expected text$")
	public void verify_the_expected()throws Throwable {
		String expected = "Find the best Dental plan for you";
		Assert.assertEquals(expected, actual );
		System.out.println("actual :" + actual);
		System.out.println("expected :" + expected);
	   
	}
	@And("^Close brower$")
	public void Close_brower() throws Throwable {
	   dr.quit();
	}
	



}
