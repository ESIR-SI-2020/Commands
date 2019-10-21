package fr.esir.jxc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.json.ModifyPasswordWrapper;

@RestController("api/v1/users")
public interface UserController {
    /**
     * @param userId
     * @param modifyPasswordWrapper the body
     */
    @PostMapping("/{userId}/password")
    public ResponseEntity modifyPassword(@PathVariable final String userId,
                                         @RequestBody ModifyPasswordWrapper modifyPasswordWrapper);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody String newUser);
}
