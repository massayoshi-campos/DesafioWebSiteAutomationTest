package br.com.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

import br.com.common.Property;
import br.com.common.Selenium;
import br.com.test.TaskItValidation;

/**
 * @author Massayohi Campos Criado em Fevereiro/2020
 * Desafio da empresa Inmetrics para automação Web, essa automação foi realizada com o framework Selenium em Java.
 * @throws InterruptedException
 * @version 1.0.0
 * @since Release 1.0
 * 
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({
		
		TaskItValidation.class,
		
		
	})

	public class AllTest {
		
		protected static WebDriver driver;

		public static Boolean isAllTestsExecution = false;

		@BeforeClass
		public static void beforeClass() throws Exception {
			isAllTestsExecution = true;
			driver = Selenium.getDriver();
			driver.navigate().to(Property.SITE_ADDRESS);
		}

		@AfterClass
		public static void afterClass() throws Exception {
			driver.quit();
		}

	}

