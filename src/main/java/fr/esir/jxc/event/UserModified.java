package fr.esir.jxc.event;

import fr.esir.jxc.models.Address;

import java.util.UUID;

public class UserModified {
    String username;
    String email;
    Address address;

    public UserModified(String email, String username, Address address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }


    public static UserModified of(String email, String username, Address address) {
        return new UserModified(
                email,
                username,
                address
        );
    }

}
