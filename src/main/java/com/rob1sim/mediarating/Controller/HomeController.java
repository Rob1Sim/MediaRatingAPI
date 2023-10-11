package com.rob1sim.mediarating.Controller;

import com.rob1sim.mediarating.Entity.DTO.LoginDTO;
import com.rob1sim.mediarating.Entity.DTO.RegisterDTO;
import com.rob1sim.mediarating.Services.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetails userService;
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> autenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User login successfuly !", HttpStatus.OK);
    }
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO){
        userService.createUser(registerDTO.toUserEntity(),2L);
        return new ResponseEntity<>("User register successfuly !", HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
