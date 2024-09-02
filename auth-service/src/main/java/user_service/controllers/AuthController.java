package user_service.controllers;


import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import java.util.logging.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;

import user_service.models.User;
import user_service.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    Logger logger;


    @Autowired
    private AuthService authService;



    @PostMapping("/registration")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws JsonProcessingException, InterruptedException, BadRequestException {
        logger.info("Registering user: " + user.getLogin() + "with password: " + user.getPassword());
        if(user == null || user.getLogin() == null || user.getPassword() == null) throw new BadRequestException();
        var token = authService.registerUser(user);
        logger.info("Registered user: " + user.getLogin() + "with password: " + user.getPassword());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) throws InterruptedException, BadRequestException {
        logger.info("username: %s, password: %s".formatted(user.getLogin(), user.getPassword()));

        if ( user==null ||user.getLogin() == null || user.getPassword() == null ) throw new BadRequestException();
        String token = authService.authenticate(user.getLogin(), user.getPassword());
        logger.info("Log in user %s ".formatted(user.toString()));
        return ResponseEntity.ok(token);
    }

}
