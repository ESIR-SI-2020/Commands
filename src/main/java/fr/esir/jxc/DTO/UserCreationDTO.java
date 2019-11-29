package fr.esir.jxc.DTO;

import fr.esir.jxc.utils.CheckEmailFormat;
import fr.esir.jxc.domain.models.Address;
import lombok.Value;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;

@Value
public class UserCreationDTO {

    public String email;
    public String username;
    public String password;
    public Address address;

    public static void validateUserCreationRequest(UserCreationDTO user) {
        if (StringUtils.isNotBlank(user.getUsername() )
                || !CheckEmailFormat.isValid(user.getEmail())
                || user.getPassword() == null
                || user.getPassword().length() < 8
        ) {
            throw new InvalidParameterException();
        }
    }
}
