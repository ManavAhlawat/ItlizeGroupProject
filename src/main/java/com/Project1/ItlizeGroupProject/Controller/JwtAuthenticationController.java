package com.Project1.ItlizeGroupProject.Controller;

import java.util.Objects;

import com.Project1.ItlizeGroupProject.Service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.Project1.ItlizeGroupProject.Service.JwtUserDetailsService;
import com.Project1.ItlizeGroupProject.Util.JwtUtil;
import com.Project1.ItlizeGroupProject.Models.AuthenticationRequest;
import com.Project1.ItlizeGroupProject.Models.AuthenticationResponse;
@RestController
//@CrossOrigin(origins = "*")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @RequestMapping(value = "/refresh-token", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAuthenticationToken(@RequestHeader("Authorization") String token) throws Exception {
        token = token.substring(7);
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));
        final String strToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(strToken));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
