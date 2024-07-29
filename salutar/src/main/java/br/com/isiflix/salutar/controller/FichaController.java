package br.com.isiflix.salutar.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isiflix.salutar.model.FichaPaciente;
import br.com.isiflix.salutar.service.ficha.IFichaService;

@RestController
@CrossOrigin("*")
public class FichaController {
	
	@Autowired
	private IFichaService service;
	
	@GetMapping("/fichas/busca")
	public ResponseEntity<List<FichaPaciente>> recuperarPeloNome(@RequestParam(name="nome") String nome) {
		List<FichaPaciente> lista = service.buscarPorNome(nome);
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		} 
		return ResponseEntity.notFound().build();		
	}
	
	@PostMapping("fichas")
	public ResponseEntity<FichaPaciente> cadastrarNovaFicha(@RequestBody FichaPaciente nova) throws Exception {
		FichaPaciente res = service.cadastrar(nova);
		if (res != null) {
			return ResponseEntity.created(new URI("/fichas/"+res.getIdFicha())).body(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("fichas/{id}")
	public ResponseEntity<FichaPaciente> buscarPeloId(@PathVariable Integer id) {
		FichaPaciente res = service.recuperarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);		
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/fichas/{id}")
	public ResponseEntity<FichaPaciente> alterarFicha(@RequestBody FichaPaciente ficha, @PathVariable Integer id) {
		if (ficha.getIdFicha() == null) {
			ficha.setIdFicha(id);
		}
		FichaPaciente res = service.alterar(ficha);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/fichas/{id}")
	public ResponseEntity<FichaPaciente> excluirFicha(@PathVariable Integer id) {
		boolean res = service.excluir(id);
		if (res) {
			return ResponseEntity.ok(service.recuperarPeloId(id));
		}
		return ResponseEntity.notFound().build();
	}
}
