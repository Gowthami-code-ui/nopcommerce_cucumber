package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features//Login.feature"},
		glue="stepdefinations",
		plugin= {"pretty", "html:reports/myreport.html"},
		dryRun=false,
		monochrome=true
		)
		
	
public class Runner {

}
 
 