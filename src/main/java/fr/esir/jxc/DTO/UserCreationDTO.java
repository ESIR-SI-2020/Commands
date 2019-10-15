package fr.esir.jxc.DTO;

import com.jxc.dbmanager.models.Address;
import lombok.Value;

@Value
public class UserCreationDTO {

    public String email;
    public String username;
    public String password;
    public Address address;

}
