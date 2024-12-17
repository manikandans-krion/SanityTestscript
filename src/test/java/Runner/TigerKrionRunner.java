package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import Testcases.JVMreports;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = "Testcases", dryRun = false, tags = "@Run",

		features = "src/test/resources/DesignProject.feature",

		plugin = { "pretty", "html:target/cucumber-report/cucumber.html",
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "json:target/cucumber-report/cucumber.json",
				"junit:target/cucumber-report/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-reports" })

public class TigerKrionRunner extends JVMreports {

	@AfterClass
	public static void report() {
		generateJVMreport(
				"C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\target\\cucumber-report\\cucumber.json");

	}

}
