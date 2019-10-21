package fr.esir.jxc;


import fr.esir.jxc.controllers.impl.UserControllerImpl;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class TestUserController {
    @InjectMocks
    private UserControllerImpl userController;

    @Mock
    private UserService userService;

    @BeforeAll
    public void setup(){
        Mockito.doNothing().when(userService).sendModifiedPasswordEvent(isA(String.class), isA(String.class));
    }

    @Test
    public void modifyPassword_ShouldReturnOK_OK(){
        ResponseEntity response = userController.modifyPassword("test@gmail.com",new user.json.ModifyPasswordDTO("oldpassword","Newpassword01&"));
        Assert.assertEquals(response.getStatusCode(),HttpStatus.OK);
    }
    @Test(expected=ResourceException.class)
    public void modifyPassword_WithBadEmail_ShouldReturnNOK_400(){
        ResponseEntity response = userController.modifyPassword("testgmail.com",new user.json.ModifyPasswordDTO("oldpassword","Newpassword01&"));
    }
}
