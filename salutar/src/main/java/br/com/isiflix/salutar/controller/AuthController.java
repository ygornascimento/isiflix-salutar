package br.com.isiflix.salutar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isiflix.salutar.model.Usuario;
import br.com.isiflix.salutar.service.auth.IAuthService;

@RestController
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private IAuthService service;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> adicionarNovoUsuario(@RequestBody Usuario novo) {
		Usuario res = service.criarUsuario(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
