package br.com.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.common.Property;
import br.com.common.Selenium;
import br.com.suite.AllTest;

public class BaseTestCase {
	
	/**
	 * @author Massayohi Campos Criado em Fevereiro/2020
	 * Desafio da empresa Inmetrics para automação Web, essa automação foi realizada com o framework Selenium em Java.
	 * @version 1.0.0
	 * @since Release 1.0
	 * 
	 */
	
	protected static WebDriver driver;

	@BeforeClass
	public static void beforeClass() throws Exception {
		if (!AllTest.isAllTestsExecution) {
			driver = Selenium.getDriver();
			driver.navigate().to(Property.SITE_ADDRESS);
			driver.manage().window().maximize();
			/*driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);*/
		}
	}

	@AfterClass
	public static void afterClass() throws Exception {
		if (!AllTest.isAllTestsExecution) {
			//driver.quit();
		}
	}
}
