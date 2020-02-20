package br.com.common;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.utils.Utils;

public class TaskItPage {

	/**
	 * @author Massayohi Campos Criado em Fevereiro/2020
	 * Desafio da empresa Inmetrics para automação Web, essa automação foi realizada com o framework Selenium em Java.
	 * @throws InterruptedException
	 * @version 1.0.0
	 * @since Release 1.0
	 * 
	 */

	/**
	 * Instância privada do WebDriver que chama a suite de teste.
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/**
	 * Construtor que adiciona a instância do WebDriver para utilização dos métodos.
	 * 
	 */

	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 40);
		driver.navigate().to(Property.SITE_ADDRESS);
	}

	// Login no sistema;
	static By clickSignHome = By
			.xpath("//ul[@class='right hide-on-med-and-down']//a[@class='modal-trigger'][contains(text(),'Sign in')]");
	static By preencherCampoName = By.xpath("//input[@placeholder='Please, tell us your login']");
	static By preencherCampoPassword = By.xpath("//input[@placeholder='Excuse me, can you tell us a secret?']");
	static By clickbuttonSign = By
			.xpath("//a[@class='modal-action waves-effect waves-green btn-flat'][contains(text(),'Sign in')]");
	
	//Validar o usuário logado.
	static By validaUserLogado = By.xpath(
			"//ul[@class='right hide-on-med-and-down']//a[@class='me'][contains(text(),'Hi, Massayoshi Campos')]");
	
	
	//Cadastro de uma task
	static By clickAdicionarAlgumasTask = By.xpath("//a[@class='waves-effect waves-light red darken-2 btn']");
	static By clickAdicionarTask = By
			.xpath("//button[@class='waves-effect waves-light red darken-2 btn modal-trigger']");
	static By preencherTitleTask = By.xpath("//input[@placeholder='What will are trying to procrastinate?']");
	static By preencherCampoDateLimitTask = By.name("date");
	static By clickButtonToday = By.xpath("//button[@class='btn-flat picker__today waves-effect']");
	static By cliclButtonClose = By.xpath("//button[@class='btn-flat picker__close waves-effect']");
	static By preencherCampoTimelimitTask = By.name("time");
	static By clicaHours = By.xpath("//div[@class='clockpicker-display-column']");
	static By clickButtonOK = By.xpath("//button[contains(text(),'OK')]");
	static By preencherCampoAboutTask = By.xpath("//textarea[@placeholder='Tell us, please!']");
	static By preencherCampoDoneTask = By.xpath("//select[@name='done']");
	static By clickSave = By.xpath("//a[@class='modal-action waves-effect waves-green btn-flat']");
	static By logoutSistem = By.xpath("//ul[@class='right hide-on-med-and-down']//a[contains(text(),'Logout')]");
	
	
	//Validação da Task criada e sua exclusão com a validação da exclusão.
	static By direcionarMyTask = By.xpath("//ul[@class='right hide-on-med-and-down']//a[contains(text(),'My tasks')]");
	static By validarTaskCriada = By.xpath("//div[@class='section']//li[1]");
	static By excluirTaskCriada = By.xpath("//li[1]//a[2]//i[1]");
	static By validaMensagemTela = By.xpath("//div[@class='toast rounded']");
	
	
	
	public TaskItPage() {

	}

	// Método que clica no botão SignIn da Home
	public static void clickButtonSignHome() {
		Utils.isVisible(clickSignHome);
		driver.findElement(clickSignHome).click();

	}

	// Método que preenche o campo Name, porém identificado com Login
	public static void preencherCampoName(String name) {
		Utils.isVisible(preencherCampoName);
		driver.findElement(preencherCampoName).clear();
		driver.findElement(preencherCampoName).sendKeys(name);

	}

	// Método que preenche o campo Password.
	public static void preencherCampoPassword(String pwd) {
		Utils.isVisible(preencherCampoPassword);
		driver.findElement(preencherCampoPassword).clear();
		driver.findElement(preencherCampoPassword).sendKeys(pwd);

	}

	// Método que clica no botão SignIn do Login
	public static void clickbuttonSign() {
		Utils.isVisible(clickbuttonSign);
		driver.findElement(clickbuttonSign).click();

	}

	// Metodo que valida se o usuário foi realmente logado na aplicação.
	public static void validaUserLogado(String mensagem) {
		Utils.isVisible(validaUserLogado);
		assertThat1("A mensagem é diferente da esperada", driver.findElement(validaUserLogado).getText(), is(mensagem));

	}

	private static void assertThat1(String string, String text, Matcher<String> matcher) {

	}

	// Método que clica no botão "Let's ADD Some Tasks!" para cadastrar uma nova task
	public static void clickAdicionarAlgumasTask() {
		Utils.isVisible(clickAdicionarAlgumasTask);
		driver.findElement(clickAdicionarAlgumasTask).click();

	}

	// Método que clica no botão "ADD a Task", direciona o usuário para tela de cadastro. 
	public static void clickAdicionarTask() {
		Utils.isVisible(clickAdicionarTask);
		driver.findElement(clickAdicionarTask).click();

	}

	// Método que preenche o campo "Title of this task".
	public static void preencherTitleTask(String title) {
		Utils.isVisible(preencherTitleTask);
		driver.findElement(preencherTitleTask).clear();
		driver.findElement(preencherTitleTask).sendKeys(title);

	}

	// Método que clica no campo "Date Limit" para preencher a data da Task
	// OBS. O campo está com bugs quando o usuário tenta preencher o campo DATA.
	@Test
	public static void preencherCampoDateLimitTask() {
		Utils.isVisible(preencherCampoDateLimitTask);
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(preencherCampoDateLimitTask);
		actions.contextClick(elementLocator).click().perform();
		
	}

	// Método que clica no botão "Today" do campo "Date limit".
	// OBS. O campo está com bugs quando o usuário tenta preencher o campo DATA.
	public static void clickButtonToday() {
		Utils.isVisible(clickButtonToday);
		driver.findElement(clickButtonToday).click();

	}

	// Método que clica no botão "OK" do campo "Date Limit".
	// OBS. O campo está com bugs quando o usuário tenta preencher o campo DATA.
	public static void cliclButtonClose() {
		Utils.isVisible(cliclButtonClose);
		driver.findElement(cliclButtonClose).click();

	}

	// Método que clica no campo "Time Limit" para preencher a hora da Task
	// OBS. O campo está com bugs quando o usuário tenta preencher o campo Hora.
	@Test
	public static void preencherCampoTimelimitTask() {
		Utils.isVisible(preencherCampoTimelimitTask);
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(preencherCampoTimelimitTask);
		actions.contextClick(elementLocator).click().perform();

	}
	
	// Método que clica no botão "OK" do campo "Time Limit".
	public static void clicaHours() throws InterruptedException {
		Thread.sleep(2500);
		Utils.isVisible(clicaHours);
		driver.findElement(clickButtonOK).click();

	}

	// Método que preenche o campo "Tell us more about it".
	public static void preencherCampoAboutTask(String about) {
		Utils.isVisible(preencherCampoAboutTask);
		driver.findElement(preencherCampoAboutTask).clear();
		driver.findElement(preencherCampoAboutTask).sendKeys(about);

	}

	// Metodo que preenche o combo "It's Done".
	public static void preencherCampoDoneTask(String estado) {
		Utils.isVisible(preencherCampoDoneTask);
		new Select(driver.findElement(preencherCampoDoneTask)).selectByVisibleText(estado);

	}

	// Método que clica no botão "Save", direciona o usuário para a tela de My Task.
	public static void clickSave() {
		Utils.isVisible(clickSave);
		driver.findElement(clickSave).click();

	}

	// Método que clica no "Logout" o usuário devesair da aplicação.
	public static void logoutSistem() {
		Utils.isVisible(logoutSistem);
		driver.findElement(logoutSistem).click();

	}

	// Método que clica no botão "My Task" e direciona o usuário para os cadastros realizados.
	public static void direcionarMyTask() {
		Utils.isVisible(direcionarMyTask);
		driver.findElement(direcionarMyTask).click();

	}

	//Método que verifica a task recém criada no sistema, validando o nome da task.
	public static void validarTaskCriada(String nomeTask) {
		Utils.isVisible(validarTaskCriada);
		asserThat("Arquivo não encontrado", driver.findElement(validarTaskCriada).getText(), is(validarTaskCriada));
	}

	private static void asserThat(String string, String text, Matcher<By> matcher) {

	}

	// Método que clica no botão excluir, o mesmo deve disponibilizar uma mensagem de confirmação.
	public static void excluirTaskCriada() {
		Utils.isVisible(excluirTaskCriada);
		driver.findElement(excluirTaskCriada).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// Método que valida a mensagem de exclusão realizada com sucesso. 
	public static void validaMensagemTela(String mensagemTela) throws InterruptedException {
		Thread.sleep(1500);
		Utils.isVisible(validaMensagemTela);
		System.out.println("Achei a mansagem");
		asserThat("Arquivo não encontrado", driver.findElement(validaMensagemTela).getText(), is(validaMensagemTela));
	}

}
