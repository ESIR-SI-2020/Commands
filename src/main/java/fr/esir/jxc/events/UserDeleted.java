package fr.esir.jxc.events;

public class UserDeleted {
    String email;

    public UserDeleted(String email) {
        this.email = email;
    }


    public static UserDeleted of(String email) {
        return new UserDeleted(
                email
        );
    }
}