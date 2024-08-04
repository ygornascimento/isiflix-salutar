package br.com.isiflix.salutar.security;

public class SalutarToken {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public SalutarToken(String token) {
		super();
		this.token = token;
	}
}
