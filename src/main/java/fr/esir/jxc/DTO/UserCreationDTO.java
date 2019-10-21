package fr.esir.jxc.DTO;

import com.jxc.dbmanager.models.Address;
import lombok.Value;

import java.security.InvalidParameterException;

@Value
public class UserCreationDTO {

    public String email;
    public String username;
    public String password;
    public Address address;

    public static void validateUserCreationRequest(UserCreationDTO user) {
        if (user.getUsername() == null
                || user.getEmail() == null
                || user.getPassword() == null
                || user.getPassword().length() < 8
        ) {
            throw new InvalidParameterException();
        }
    }
}
