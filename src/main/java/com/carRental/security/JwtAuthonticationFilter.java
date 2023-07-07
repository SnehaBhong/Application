package com.carRental.security;

import com.carRental.helper.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthonticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestToken=request.getHeader("Authorization");
        String token=null;
        String username=null;

        if(requestToken!=null && requestToken.startsWith("Bearer")){
            token=requestToken.substring(7);
            System.out.println(token);
            try {
                username = this.jwtUtil.extractUsername(token);
            }catch (IllegalArgumentException e){
                System.out.println("invalid credential");
            }catch (ExpiredJwtException e){
                System.out.println("token is expired");
            }catch (MalformedJwtException e)
            {
                System.out.println("invalid!!");
            }
        }else {
            System.out.println("token not found");
        }
        System.out.println(username);

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(this.jwtUtil.validateToken(token,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request ));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken );
            }
            else {
                System.out.println("invalid ");
            }

        }else {
            System.out.println("username is null or context is not null!!");
        }
        filterChain.doFilter(request,response);
    }
}
