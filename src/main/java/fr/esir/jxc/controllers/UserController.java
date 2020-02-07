package fr.esir.jxc.controllers;

import java.security.InvalidParameterException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.esir.jxc.DTO.UserCreationDTO;
import fr.esir.jxc.services.UserReadService;
import fr.esir.jxc.services.UserWriteService;
import fr.esir.jxc.services.UserCreationService;

@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserReadService userReadService;
    @Autowired
    private final UserWriteService userWriteService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createUser(@RequestBody UserCreationDTO newUser) throws InvalidParameterException {
        UserCreationService.validateUserCreationRequest(newUser);

        if (this.userReadService.findByUsername(newUser.getUsername()).isPresent()
                || this.userReadService.findByEmail(newUser.getEmail()).isPresent()) {
            log.warn("User already existing for username {0} or email {1}.", newUser.getUsername(), newUser.getEmail());

            throw new InvalidParameterException();
        }

        this.userWriteService.create(newUser);
    }
}
