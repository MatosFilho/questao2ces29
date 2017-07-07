package steps;

import cucumber.api.java.es.Dado;
import static org.junit.Assert.*;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import source.VulnerableClass;


public class classeStepsTest {
	
	VulnerableClass vc;
	String arquivo;
	String msg;
	
	@Dado("^um arquivo com nome inválido$")
	public void um_arquivo_com_nome_inválido() {
	    arquivo = "!nãoabrir!";
	}

	@Quando("^ocorre a tentativa de abrir o arquivo$")
	public void ocorre_a_tentativa_de_abrir_o_arquivo() {
	    msg = vc.vulnerableMethod(arquivo);
	}

	@Então("^uma mensagem de erro é mostrada$")
	public void uma_mensagem_de_erro_é_mostrada() {
	  assertEquals ("Nome de arquivo não atende aos padrões.", msg);
	}
	
	@Dado("^um arquivo com nome válido para leitura$")
	public void um_arquivo_com_nome_válido_para_leitura(){
		arquivo = "arq.txt";
	}

	@Quando("^o arquivo é aberto e definido para leitura$")
	public void o_arquivo_é_aberto_e_definido_para_leitura() {
		vc.setBuffer("R");
		msg = vc.vulnerableMethod(arquivo);
		
	}

	@Então("^o resultado do arquivo é mostrado na tela$")
	public void o_resultado_do_arquivo_é_mostrado_na_tela() {
		assertEquals ("Arquivo impresso na tela com sucesso.", msg);
	}
	
	@Dado("^um arquivo com nome válido para ser escrito$")
	public void um_arquivo_com_nome_válido_para_ser_escrito() {
	    arquivo = "arq2.txt";
	}

	@Quando("^o arquivo é aberto e definido para escrita$")
	public void o_arquivo_é_aberto_e_definido_para_escrita() {
	   vc.setBuffer("W");
	   vc.setTexto("Escrita feita");
	   msg = vc.vulnerableMethod(arquivo);
	}

	@Então("^a escrita é realizada e mostrada na tela$")
	public void a_escrita_é_realizada_e_mostrada_na_tela() {
	    assertEquals("Escrita de arquivo realizada com sucesso.", msg);
	}
	
	@Dado("^o usuario abriu um arquivo$")
	public void o_usuario_abriu_um_arquivo() {
		arquivo = "arq.txt";
	}

	@Quando("^ele não quer mais o modificar$")
	public void ele_não_quer_mais_o_modificar() {
	    vc.setBuffer("EXIT");
	    msg = vc.vulnerableMethod(arquivo);
	}

	@Então("^ele decide sair$")
	public void ele_decide_sair()  {
		assertEquals ("Fim da manipulacao do arquivo.", msg);
	}
	
	@Dado("^que o usuario abriu corretamente um arquivo$")
	public void que_o_usuario_abriu_corretamente_um_arquivo() {
		arquivo = "arq.txt";
	}

	@Quando("^ele escolhe um comando não válido$")
	public void ele_escolhe_um_comando_não_válido() {
		vc.setBuffer("k");
		msg = vc.vulnerableMethod(arquivo);
	}

	@Então("^ele é avisado do ocorrido$")
	public void ele_é_avisado_do_ocorrido() {
	    assertEquals ("Comando invalido. Tente novamente.", msg);
	}
	
}
