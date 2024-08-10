package br.com.isiflix.salutar.security;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

import br.com.isiflix.salutar.model.Usuario;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import javax.crypto.SecretKey;

public class TokenUtil {

    // aqui vamos definir alguns parametros de configuracao do token
    // - duracao
    // - emissor
    // - chave

    public static final long SEGUNDOS   = 1000;
    public static final long MINUTOS    = 60 * SEGUNDOS;
    public static final long HORAS      = 60 * MINUTOS;
    public static final long DIAS       = 24 * HORAS;
    public static final long EXPIRATION = 5 * DIAS;

    public static final String ISSUER   = "*IsiFLIX*";

    public static final String SECRET_KEY = "01234567890123456789012345678901";

    public static final String PREFIX = "Bearer ";


    public static SalutarToken encode(Usuario usuario) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        String jws = Jwts.builder().setSubject(usuario.getLogin())
                .setIssuer(ISSUER)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return new SalutarToken(jws);
    }

    public static Authentication decode(HttpServletRequest request) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
//        token = token.replace(PREFIX, "");  // simplesmente retiro a palavar BEARER
        token = token.replace("Bearer \"", "");
        token = token.replaceAll("\"", "");
        Jws<Claims> claims;
        claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build()
                .parseClaimsJws(token);

        String subject = claims.getBody().getSubject();
        String issuer  = claims.getBody().getIssuer();
        Date   exp     = claims.getBody().getExpiration();
        if (isValid(subject, issuer, exp)) {
            return new UsernamePasswordAuthenticationToken(subject, null, Collections.emptyList());
        }
        return null;
    }

    public static boolean isValid(String subject, String issuer, Date exp) {
        return subject != null && subject.length() > 0 && issuer.equals(ISSUER) && exp.after(new Date(System.currentTimeMillis()));
    }
}
