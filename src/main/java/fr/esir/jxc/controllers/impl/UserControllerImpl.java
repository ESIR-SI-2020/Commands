package fr.esir.jxc.controllers.impl;

import fr.esir.jxc.DTO.ModifyPasswordDTO;
import fr.esir.jxc.DTO.ModifyUserDTO;
import fr.esir.jxc.controllers.UserController;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.services.UserService;
import fr.esir.jxc.utils.Patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    public void modifyPassword(String email, ModifyPasswordDTO modifyPasswordDTO) {
        //controle wrapper(new password)
        String oldPassword = modifyPasswordDTO.getOldPassword();
        String newPassword = modifyPasswordDTO.getNewPassword();
        if (oldPassword == null || newPassword == null) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Given new password or old password are empty.");
        }
        if (!Patterns.EMAIL_PATTERN.matcher(email).matches()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : The given email is in the wrong format)");
        }
        if (!Patterns.PASSWORD_PATTERN.matcher(newPassword).matches()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Your password must have : Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character");
        }
        //TODO token authentification ?

        checkOldPassword(email, oldPassword);

        userService.sendModifiedPasswordEvent(email, newPassword);
    }

    @Override
    public void createUser(String newUser) {

    }

    @Override
    public void modifyUser(String email, ModifyUserDTO modifyUserDTO) {
        if (!Patterns.EMAIL_PATTERN.matcher(email).matches()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : The given email is in the wrong format)");
        }
        //getUser ?
        //if not exists
        // 404
        //else
        userService.sendModifiedUserEvent(email, modifyUserDTO.getUsername(), modifyUserDTO.getAddress());
    }

    @Override
    public void deleteUser(String email) {
        if (!Patterns.EMAIL_PATTERN.matcher(email).matches()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : The given email is in the wrong format)");
        }
        //getUser ?
        //if not exists
        // 404
        //else
        userService.sendDeletedUserEvent(email);
    }

    private void checkOldPassword(String email, String oldPassword) {
        // TODO check password
        if (false) {
            throw new ResourceException(HttpStatus.UNAUTHORIZED, "Unauthorized : bad user ID and password");
        }
    }
}
