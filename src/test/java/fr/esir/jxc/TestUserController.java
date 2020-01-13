package fr.esir.jxc;

import fr.esir.jxc.DTO.ModifyPasswordRequest;
import fr.esir.jxc.controllers.impl.UserControllerImpl;
import fr.esir.jxc.exceptions.ResourceException;
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
    public void setup() {
        Mockito.doNothing().when(userService).sendModifiedPasswordEvent(isA(String.class), isA(String.class));
    }

    @Test
    public void modifyPassword_OK() {
        ResponseEntity response = userController.modifyPassword("test@gmail.com", new ModifyPasswordRequest("oldpassword", "Newpassword01&"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test(expected = ResourceException.class)
    public void modifyPassword_WithBadEmail() {
        ResponseEntity response = userController.modifyPassword("testgmail.com", new ModifyPasswordRequest("oldpassword", "Newpassword01&"));
    }
}
