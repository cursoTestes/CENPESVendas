package br.scrumban;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeUmaVendaInterfaceTest {
	protected WebDriver driver ;
	
	@Before
	public void  instanciaChrome()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@After
	public void  fechaChrome()
	{
		driver.quit();
	}
	
	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		driver.get("http://localhost:58034/Venda/Add");
		
		driver.findElement(By.id("Vendedor")).sendKeys("");
		driver.findElement(By.id("DataVenda")).sendKeys("");
		driver.findElement(By.id("Valor")).sendKeys("");
		
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.",driver.findElement(By.id("validacaoVendedor")).getText()); 
		Assert.assertEquals("O campo Valor é obrigatório.",driver.findElement(By.id("validacaoValor")).getText()); 
		Assert.assertEquals("O campo Data Venda é obrigatório.", driver.findElement(By.id("validacaoDataVenda")).getText());
					
	}

	@Test
	public void teste_cadastra_uma_venda_ComDataFutura() {
		driver.get("http://localhost:58034/Venda/Add");
		
		driver.findElement(By.id("Vendedor")).sendKeys("10");
		driver.findElement(By.id("DataVenda")).sendKeys("01/01/2020");
		driver.findElement(By.id("Valor")).sendKeys("10");
		
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		String mensagemCampoData = driver.findElement(By.id("validacaoDataVenda")).getText();
		Assert.assertEquals("O campo Data Venda não pode ser maior que a data atual.", mensagemCampoData);
					
	}

	@Test
	public void teste_cadastra_uma_venda_ComCampoValorNaoNumerico() {
		driver.get("http://localhost:58034/Venda/Add");
		
		driver.findElement(By.id("Vendedor")).sendKeys("10");
		driver.findElement(By.id("DataVenda")).sendKeys("01/01/2010");
		driver.findElement(By.id("Valor")).sendKeys("a");
		
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		String mensagemCampoData = driver.findElement(By.id("validacaoValor")).getText();
		Assert.assertEquals("O campo Valor deve ser numérico.", mensagemCampoData);
					
	}

	
}
