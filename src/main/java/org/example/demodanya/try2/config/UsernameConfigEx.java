package org.example.demodanya.try2.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class UsernameConfigEx extends UsernamePasswordAuthenticationFilter {
    //прописать класс AuthenticationManager
    public UsernameConfigEx() {
        setFilterProcessesUrl("auth/login");
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        //как только пользователь вызовет логин, он попадет сюда. Тут нужно достать из request логин и пароль. И сделать так,
        // чтобы у AuthenticationManager есть метод authenticate, он должен вызываться и я передаю туда логин и пароль.
        //на выходе возвращается объект аутентификации
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth){
        UserDetails principal = (UserDetails) auth.getPrincipal();//сюда магией подтягивается возвращаемый объект UserDetails. Мы getPrincipal кастим, чтобы поменять его тип на UserDetails и были доступны методы UserDetails
        principal.getAuthorities() //в getAuthorities лежит список ролей юзера. Нужно их достать в стрку и засунуть в токен, сгенерировать токен и отдать его пользователю на выходе через объект response
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed){
        //его переопределяем, чтобы понять что он делает. Нужно посмотреть что делает по умолчанию и поменять чуть чуть
    }
}
