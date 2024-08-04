package br.com.isiflix.salutar.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.isiflix.salutar.dao.UsuarioDAO;
import br.com.isiflix.salutar.model.Usuario;
import br.com.isiflix.salutar.security.SalutarToken;

@Component
public class AuthServiceImpl implements IAuthService {
	
	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario criarUsuario(Usuario novoUsuario) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(novoUsuario.getSenha());
		novoUsuario.setSenha(novaSenha);
		
		return dao.save(novoUsuario);
	}

	@Override
	public SalutarToken realizarLogin(Usuario dadosLogin) {
		// TODO Auto-generated method stub
		Usuario res = dao.findByLogin(dadosLogin.getLogin());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if (res != null) {
			if (encoder.matches(dadosLogin.getSenha(), res.getSenha())) {
				return new SalutarToken("isidro123");
			}
		}
		return null;
	}
	
}
