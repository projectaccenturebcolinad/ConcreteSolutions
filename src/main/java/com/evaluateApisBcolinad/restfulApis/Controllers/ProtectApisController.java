package com.evaluateApisBcolinad.restfulApis.Controllers;

import com.evaluateApisBcolinad.restfulApis.CustomClass.TokenProfile;
import com.evaluateApisBcolinad.restfulApis.Repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/protectApis")
public class ProtectApisController {

    private final UserRepository repoUser;

    private Logger logsProtectApisController = LogManager.getLogger(ProtectApisController.class);

    ProtectApisController(UserRepository repoUser) {
        this.repoUser = repoUser;
    }
    
    //Get Users
    @GetMapping("/getUsers")
    ResponseEntity<?> getUsers() {
        logsProtectApisController.info("Api getUsers - Call Success");
        return ResponseEntity.ok().body(repoUser.findAll());
    }

}
