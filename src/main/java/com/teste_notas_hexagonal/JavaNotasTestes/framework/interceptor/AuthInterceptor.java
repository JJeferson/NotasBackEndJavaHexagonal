package com.teste_notas_hexagonal.JavaNotasTestes.framework.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.google.gson.Gson;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teste_notas_hexagonal.JavaNotasTestes.framework.errors.Error;

import java.util.Base64;

public class AuthInterceptor implements HandlerInterceptor {

    private String token;

    public AuthInterceptor(String Token) {
        this.token = Token;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");



        try {
            if(authorization==null) {
                Error error = new Error("401", "Unauthorized Request", "Precisa informar um header Authorization", 1);
                response.getWriter().write(new Gson().toJson(error));
                response.setStatus(401);
                response.setContentType("application/json");
                return false;
            }

            byte[] tokenDecoded = Base64.getDecoder().decode(authorization);
            String tokenComoString = new String(tokenDecoded);

            if(!tokenComoString.equals(token)){
                Error error = new Error("401", "Unauthorized Request",
                        "Token está errado. Verifique.", 1);
                response.getWriter().write(new Gson().toJson(error));
                response.setStatus(401);
                response.setContentType("application/json");
                return false;
            }
        } catch(TokenExpiredException ex) {

            Error error = new Error("401", "Unauthorized Request", "Token expirado", 1);
            response.getWriter().write(new Gson().toJson(error));
            response.setStatus(401);
            response.setContentType("application/json");

            return false;
        } catch(JWTDecodeException e) {

            Error error = new Error("401", "Unauthorized Request", "Token inválido", 1);
            response.getWriter().write(new Gson().toJson(error));
            response.setStatus(401);
            response.setContentType("application/json");

            return false;

        } catch(Exception e) {

            Error error = new Error("401", "Unauthorized Request", e.getMessage(), 1);
            response.getWriter().write(new Gson().toJson(error));
            response.setStatus(401);
            response.setContentType("application/json");

            return false;
        }

        return true;

    }

}