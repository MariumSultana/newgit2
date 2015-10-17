package com.cucumber1st.MevanCucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		features = "src/test/source"
		)
public class RunnerTest {

}
