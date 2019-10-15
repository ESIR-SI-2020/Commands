package fr.esir.jxc.services;

public interface UserService {
    void sendModifiedPasswordEvent(String email, String newPassword);
}
