package br.com.test;

import org.junit.Test;

import br.com.common.TaskItPage;

/**
 * @author Massayohi Campos Criado em Fevereiro/2020
 * Desafio da empresa Inmetrics para automação Web, essa automação foi realizada com o framework Selenium em Java.
 * @throws InterruptedException
 * @version 1.0.0
 * @since Release 1.0
 * 
 */

public class TaskItValidation extends BaseTestCase{
	
	@Test
	public void TaskItValidationTest() throws Exception{
		
		
		//Login e validação do usuário logado
		TaskItPage.clickButtonSignHome();
		TaskItPage.preencherCampoName("Massa");
		TaskItPage.preencherCampoPassword("1234");
		TaskItPage.clickbuttonSign();
		TaskItPage.validaUserLogado("Hi, Massayoshi Campos");
		
		//Criação do cadastro da Task
		TaskItPage.clickAdicionarAlgumasTask();
		TaskItPage.clickAdicionarTask();
		TaskItPage.preencherTitleTask("Teste");
		TaskItPage.preencherCampoDateLimitTask();
		Thread.sleep(1500);
		TaskItPage.clickButtonToday();
		TaskItPage.cliclButtonClose();
		TaskItPage.preencherCampoTimelimitTask();
		Thread.sleep(1500);
		TaskItPage.clicaHours();
		TaskItPage.preencherCampoAboutTask("Teste");
		TaskItPage.preencherCampoDoneTask("Yes");
		TaskItPage.clickSave();
		TaskItPage.logoutSistem();
		
		//Login e validação da task criada e exclusão da task e validação da exclusão.
		TaskItPage.clickButtonSignHome();
		TaskItPage.preencherCampoName("Massa");
		TaskItPage.preencherCampoPassword("1234");
		TaskItPage.clickbuttonSign();
		TaskItPage.direcionarMyTask();
		TaskItPage.validarTaskCriada("Teste");
		TaskItPage.excluirTaskCriada();
		TaskItPage.validaMensagemTela("Finally, I no longer need to set eyes on you damn task!");
		TaskItPage.logoutSistem();
			
	}
}
