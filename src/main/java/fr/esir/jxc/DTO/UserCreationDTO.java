package fr.esir.jxc.DTO;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import fr.esir.jxc.domain.models.Address;

@Slf4j
@Value
public class UserCreationDTO {

    public final String email;
    public final String username;
    public final String password;
    public final Address address;

}
