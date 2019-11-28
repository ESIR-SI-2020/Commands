package fr.esir.jxc.models;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
