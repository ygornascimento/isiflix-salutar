package br.com.isiflix.salutar.service.auth;

import br.com.isiflix.salutar.model.Usuario;
import br.com.isiflix.salutar.security.SalutarToken;

public interface IAuthService {
	Usuario criarUsuario(Usuario novo);
	SalutarToken realizarLogin(Usuario dadosLogin);
}
