package com.evaluateApisBcolinad.restfulApis.Controllers;

import com.evaluateApisBcolinad.restfulApis.CustomClass.TokenProfile;
import com.evaluateApisBcolinad.restfulApis.CustomClass.UserCreate;
import com.evaluateApisBcolinad.restfulApis.CustomClass.UserLogin;
import com.evaluateApisBcolinad.restfulApis.Entities.User;
import com.evaluateApisBcolinad.restfulApis.JWT.JwtTokenProvider;
import com.evaluateApisBcolinad.restfulApis.Repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repoUser;

    private Logger logsAuthController = LogManager.getLogger(AuthController.class);

    private static final String messageTypeOne = "{\"message\":\"Usuario o contraseña inválidos\"}";

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    AuthController(UserRepository repoUser) {
        this.repoUser = repoUser;
    }

    @PostMapping("/signIn")
    ResponseEntity signIn(@RequestBody UserLogin userLoginBody) {
        User findEmail = repoUser.findByEmail(userLoginBody.getEmail());
        if (findEmail == null) {
            logsAuthController.error("Api singIn - Email Dont Exist");
            return new ResponseEntity<String>(messageTypeOne, HttpStatus.NOT_FOUND);
        }
        try {
            String username = userLoginBody.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userLoginBody.getPassword()));
            String token = jwtTokenProvider.createToken(username, findEmail.getRoles());
            logsAuthController.info("Api signIn - Success Create Token And Sesion User");
            int dataUserUpdate = repoUser.updateUser(username,token,LocalDateTime.now());
            logsAuthController.info("Api signIn - Success Update User");
            return ResponseEntity.ok().body("{\"message\":\""+token+"\"}");
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(messageTypeOne);
        }
    }

    //Create User
    @PostMapping("/signUp")
    ResponseEntity<?> signUp(
            @Valid @RequestBody UserCreate userCreateBody
    ) {
        //Validate User
        User userResult = repoUser.findByEmail(userCreateBody.getEmail());
        if (userResult != null) {
            //Log Error
            logsAuthController.error("Api signUp - Email Exist");
            return new ResponseEntity<String>("{\"message\":\"El correo ya registrado\"}", HttpStatus.NOT_FOUND);
        }
        //Generate User
        User newUser = new User(
                userCreateBody.getName(),
                userCreateBody.getEmail(),
                passwordEncoder.encode(userCreateBody.getPassword()),
                userCreateBody.getPhones().toString(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                Arrays.asList( "ROLE_USER","ROLE_ADMIN")
        );
        //Create User
        repoUser.save(newUser);
        //Log Success
        logsAuthController.info("Api signUp - Success Creation User");
        return ResponseEntity.ok().body(userCreateBody);
    }

}
