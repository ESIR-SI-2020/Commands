package fr.esir.jxc.controllers.impl;

import fr.esir.jxc.controllers.UserController;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.services.UserService;
import fr.esir.jxc.utils.Patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    public ResponseEntity modifyPassword(String userId, user.json.ModifyPasswordRequest modifyPasswordRequest) {
        //controle wrapper(new password)
        String oldPassword = modifyPasswordRequest.getOldPassword();
        String newPassword = modifyPasswordRequest.getNewPassword();
        if (oldPassword == null || newPassword == null) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Given new password or old password are empty.");
        }
        if (!Patterns.EMAIL_PATTERN.matcher(userId).matches()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : The given email is in the wrong format)");
        }
        if (!Patterns.PASSWORD_PATTERN.matcher(newPassword).matches()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Your password must have : Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character");
        }
        //TODO token authentification ?

        checkOldPassword(userId, oldPassword);

        userService.sendModifiedPasswordEvent(userId, newPassword);

        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.NO_CONTENT);
    }

    @Override
    public void createUser(String newUser) {

    }

    private void checkOldPassword(String userId, String oldPassword) {
        // TODO check password
        if (false) {
            throw new ResourceException(HttpStatus.UNAUTHORIZED, "Unauthorized : bad user ID and password");
        }
    }
}
