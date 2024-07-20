package br.com.isiflix.salutar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.isiflix.salutar.model.FichaPaciente;
import br.com.isiflix.salutar.service.ficha.IFichaService;

@SpringBootTest
public class FichaTests {
	
	@Autowired
	IFichaService service;
	
	@Test
	public void shouldCreateFicha() {
		FichaPaciente f = new FichaPaciente();
		
		f.setNomePaciente("Isidro");
		FichaPaciente res = service.cadastrar(f);
		
		assertTrue(res != null && res.getUuid() != null && res.getAtivo() == 1);
	}
	
	@Test
	public void shouldDeleteFicha() {
		assertTrue(service.excluir(1));
	}
	
	@Test
	public void shouldNotDeleteFicha() {
		assertFalse(service.excluir(123456789));
	}

}
