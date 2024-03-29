package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.ValidJwt;
import io.jsonwebtoken.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidJwtValidator implements ConstraintValidator<ValidJwt, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException e) {
//            logger.error("Invalid JWT signature: {}", e.getMessage());
//        } catch (MalformedJwtException e) {
//            logger.error("Invalid JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            logger.error("JWT token is expired: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            logger.error("JWT token is unsupported: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims string is empty: {}", e.getMessage());
//        }
        return false;
    }
}