package com.bank.first_bank.config;

import com.bank.first_bank.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Component
@RequiredArgsConstructor
public class JwtAuthenticationFiler extends OncePerRequestFilter {

private static final String AUTHORIZATION="Authorization";
private final UserRepository userRepository;
private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader(AUTHORIZATION);
        String userEmail= null;
        String jwt = null;

    }
}
