package org.example.demodanya.try2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demodanya.try2.controllers.ErrorInfo;
import org.example.demodanya.try2.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    //прописать класс AuthenticationManager +++
    private final JwtUtil jwtUtil;
    private final ObjectMapper objectMapper;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                                      ObjectMapper objectMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.objectMapper = objectMapper;
        setFilterProcessesUrl("/auth/login");
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authRequest);
        //как только пользователь вызовет логин, он попадет сюда. Тут нужно достать из request логин и пароль. И сделать так,
        // чтобы у AuthenticationManager есть метод authenticate, он должен вызываться и я передаю туда логин и пароль.
        //на выходе возвращается объект аутентификации +++
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth){
        UserDetails principal = (UserDetails) auth.getPrincipal();//сюда магией подтягивается возвращаемый объект UserDetails. Мы getPrincipal кастим, чтобы поменять его тип на UserDetails и были доступны методы UserDetails
        String roles = principal.getAuthorities().stream()//в getAuthorities лежит список ролей юзера. Нужно их достать в стрку и засунуть в токен, сгенерировать токен и отдать его пользователю на выходе через объект response
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        String token = jwtUtil.generateToken(principal.getUsername(), roles);
        response.addHeader("Authorization", "Bearer " + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        PrintWriter out = response.getWriter();
        String errorMessage = "ты зашел не в ту дверь, сынок. " + failed.getMessage();
        out.print(
                objectMapper.writeValueAsString(new ErrorInfo(errorMessage))
        );
        //его переопределяем, чтобы понять что он делает. Нужно посмотреть что делает по умолчанию и поменять чуть чуть
    }
}
