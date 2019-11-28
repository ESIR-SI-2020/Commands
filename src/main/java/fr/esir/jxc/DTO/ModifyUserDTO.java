package fr.esir.jxc.DTO;
import fr.esir.jxc.models.Address;
import lombok.Value;

@Value
public class ModifyUserDTO {
    private String username;
    private Address address;

}
