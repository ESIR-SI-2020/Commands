package fr.esir.jxc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("api/v1/users")
public interface UserController {
    /**
     * @param userId
     * @param modifyPasswordRequest the body
     */
    @PostMapping("/{userId}/password")
    public ResponseEntity modifyPassword(@PathVariable final String userId,
                                         @RequestBody user.json.ModifyPasswordRequest modifyPasswordRequest);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody String newUser);
}
