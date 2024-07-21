package br.com.isiflix.salutar.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
