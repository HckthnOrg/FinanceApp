package com.example.financeapp.config;

import com.example.financeapp.service.JwtService;
import com.example.financeapp.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    public static final String BEARER_PREFIX = "Bearer";
    public static final String HEADER_NAME = "Authorization";
    public final JwtService jwtService;
    public final UserService userService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader = request.getHeader(HEADER_NAME);
        if (!isAuthHeaderValid(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = extractJwtToken(authHeader);
        String username = jwtService.extractUsername(jwt);

        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() != null) {
            UserDetails userDetails = getUserDetails(username);

            if (jwtService.isTokenValid(jwt, userDetails)) {
                setSecurityContext(request, userDetails);
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean isAuthHeaderValid(HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER_NAME);
        return StringUtils.isEmpty(authHeader) || StringUtils.startsWith(authHeader, BEARER_PREFIX);
    }

    private String extractJwtToken(String authHeader) {
        return authHeader.substring(BEARER_PREFIX.length());
    }

    private UserDetails getUserDetails(String username) {
        return userService.userDetailsService().loadUserByUsername(username);
    }

    private void setSecurityContext(HttpServletRequest request, UserDetails userDetails) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );

        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        context.setAuthentication(authToken);
        SecurityContextHolder.setContext(context);
    }
}
