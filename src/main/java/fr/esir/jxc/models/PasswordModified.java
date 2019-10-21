package fr.esir.jxc.models;
import java.util.UUID;
import lombok.Value;

@Value
public class PasswordModified {

        String id;
        String password;
        String email;

    public PasswordModified(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }


    public static PasswordModified of(String email, String password) {
            return new PasswordModified(
                    UUID.randomUUID().toString(),
                    password,
                    email
            );
        }

}

