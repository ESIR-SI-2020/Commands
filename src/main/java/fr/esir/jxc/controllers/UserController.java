package fr.esir.jxc.controllers;

import fr.esir.jxc.DTO.UserCreationDTO;
import fr.esir.jxc.services.UserReadService;
import fr.esir.jxc.services.UserWriteService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;


@RestController("/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserReadService userReadService;
    @Autowired
    private final UserWriteService userWriteService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserCreationDTO newUser) {
        UserCreationDTO.validateUserCreationRequest(newUser);

        if (this.userReadService.findByUsername(newUser.getUsername()).isPresent()
                || this.userReadService.findByEmail(newUser.getEmail()).isPresent()) {
            logger.warn("User already existing for username {0} or email {1}.", newUser.getUsername(), newUser.getEmail());

            throw new InvalidParameterException();
        }

        this.userWriteService.create(newUser);
    }
}
