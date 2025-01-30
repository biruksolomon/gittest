//package com.example.EMS.EMS.Config;
//
//import com.example.EMS.EMS.Security.JwtUtil;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.net.Authenticator;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private Authenticator authenticationManager;
//    private JwtUtil jwtUtil;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token = extractToken(request);
//        if (token != null && jwtUtil.validateToken(token, extractUsername(token))) {
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(extractUsername(token), null, new ArrayList<>());
//            SecurityConfig.getContext().setAuthentication(authentication);
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String extractToken(HttpServletRequest request) {
//        String header = request.getHeader("Authorization");
//        if (header != null && header.startsWith("Bearer ")) {
//            return header.substring(7);
//        }
//        return null;
//    }
//
//    private String extractUsername(String token) {
//        return jwtUtil.extractUsername(token);
//    }
//}
//
