package fr.esir.jxc.controllers;

import fr.esir.jxc.DTO.ModifyPasswordDTO;
import fr.esir.jxc.DTO.ModifyUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("api/v1/users")
public interface UserController {

    @PostMapping("/{email}/password")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void modifyPassword(@PathVariable final String email,
                                         @RequestBody ModifyPasswordDTO modifyPasswordDTO);

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createUser(@RequestBody String newUser);

    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void modifyUser(@PathVariable final String email,
                                     @RequestBody ModifyUserDTO modifyUserDTO);

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable final String email);
}
