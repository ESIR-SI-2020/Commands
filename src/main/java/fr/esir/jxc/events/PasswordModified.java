package fr.esir.jxc.events;
import lombok.Value;

@Value
public class PasswordModified {

        String password;
        String email;

    public PasswordModified(String password, String email) {
        this.password = password;
        this.email = email;
    }


    public static PasswordModified of(String email, String password) {
            return new PasswordModified(
                    password,
                    email
            );
        }

}

