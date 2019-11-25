package com.autotest.practise.yourlogo.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:resources/runtest.feature", glue = "com.autotest.practise.yourlogo.steps")
public class RunnerTest {

}
