package fr.esir.jxc.DTO;

<<<<<<< HEAD
import fr.esir.jxc.utils.CheckEmailFormat;
import fr.esir.jxc.domain.models.Address;
=======
>>>>>>> User creation refinements according to PR comments. Updated dependency to Domain module.
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
