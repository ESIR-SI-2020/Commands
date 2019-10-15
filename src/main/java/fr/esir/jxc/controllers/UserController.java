package fr.esir.jxc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.json.ModifyPasswordWrapper;

@RestController
public interface UserController {
    /**
     * @param userId
     * @param modifyPasswordWrapper the body
     */
    @PostMapping("/user/{userId}/password")
    public ResponseEntity modifyPassword(@PathVariable final String userId,
                                         @RequestBody ModifyPasswordWrapper modifyPasswordWrapper);
}