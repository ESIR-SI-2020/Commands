package fr.esir.jxc.models.DTO;

import fr.esir.jxc.models.Address;
import lombok.Value;

@Value
public class UserCreationDTO {

    public String email;
    public String username;
    public String password;
    public Address address;

}
