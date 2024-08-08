package br.com.isiflix.salutar.security;

import java.security.Key;
import java.util.Date;
import javax.crypto.SecretKey;

import br.com.isiflix.salutar.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenService {
	public static final long   EXPIRATION = 60 * 1000;
	public static final String EMISSOR = "Isiflix";
	public static final String SECRET_KEY = "01234567890123456789012345678901"; // 32 caracteres
	
	
	public static IsiToken encode(Usuario usuario) {
		try {
			// defino a chave que irá criptografar meu JWT
			Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
			// gero um JWT builder com os seguintes elementos:
			// subject -- a string q representa o usuario
			// expiration -- a data atual + 1 minuto
			String jwtToken = Jwts.builder()
						  	      .subject(usuario.toString())
						  	      .expiration(new Date(System.currentTimeMillis()+EXPIRATION))
						  	      .signWith(key)
						  	      .compact();
			IsiToken token = new IsiToken(jwtToken);
			return token;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Usuario decode(IsiToken token) {
		try {
			// seleciono o algoritmo para a chave especificada
			SecretKey secret = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
			
			// crio o parser que vai decodificar o token
			JwtParser jwtParser = Jwts.parser().verifyWith(secret).build();
			
			// faço a decodificação e retorno um objeto que conterá esse Payload
			Claims claims = (Claims)jwtParser.parse(token.getToken()).getPayload();
		    
			// extraio aquilo q eu preciso
			String strUser = claims.getSubject();
		
			return Usuario.fromString(strUser);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}