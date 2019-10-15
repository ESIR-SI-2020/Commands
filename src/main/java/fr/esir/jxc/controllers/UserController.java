package fr.esir.jxc.controllers;

import fr.esir.jxc.DTO.UserCreationDTO;
import fr.esir.jxc.services.UserReadService;
import fr.esir.jxc.services.UserWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UserController {
    @Autowired
    private final UserReadService userReadService;
    @Autowired
    private final UserWriteService userWriteService;

    public UserController(UserReadService userReadService, UserWriteService userWriteService) {
        this.userReadService = userReadService;
        this.userWriteService = userWriteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserCreationDTO newUser) {

    }
}
