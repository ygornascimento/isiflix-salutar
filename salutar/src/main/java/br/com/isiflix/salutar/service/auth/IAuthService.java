package br.com.isiflix.salutar.service.auth;

import br.com.isiflix.salutar.model.Usuario;
import br.com.isiflix.salutar.security.IsiToken;
import br.com.isiflix.salutar.security.SalutarToken;

public interface IAuthService {
	public Usuario criarUsuario(Usuario novo);
	public SalutarToken realizarLogin(Usuario dadosLogin);
//	public IsiToken realizarLogin(Usuario dadosLogin);
}
