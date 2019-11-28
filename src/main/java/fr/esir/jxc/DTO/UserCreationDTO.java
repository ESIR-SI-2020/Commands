package fr.esir.jxc.DTO;

import com.jxc.dbmanager.models.Address;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;

@Value
public class UserCreationDTO {

    public String email;
    public String username;
    public String password;
    public Address address;

    private final static Logger logger = LoggerFactory.getLogger(UserCreationDTO.class);

    public static void validateUserCreationRequest(UserCreationDTO user) {
        if (user.getUsername() == null
                || user.getEmail() == null
                || user.getPassword() == null
                || user.getPassword().length() < 8
        ) {
            logger.warn("Invalid or missing mandatory argument.");

            throw new InvalidParameterException();
        }
    }
}
