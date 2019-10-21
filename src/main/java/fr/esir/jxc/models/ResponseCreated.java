package fr.esir.jxc.models;
import java.util.UUID;
import lombok.Value;

@Value
public class ResponseCreated {

        String id;
        String password;
        String email;

    public ResponseCreated(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }


    public static ResponseCreated of(String email, String password) {
            return new ResponseCreated(
                    UUID.randomUUID().toString(),
                    password,
                    email
            );
        }

}

