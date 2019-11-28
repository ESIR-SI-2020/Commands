package fr.esir.jxc.services;

import fr.esir.jxc.models.Address;

public interface UserService {
    void sendModifiedPasswordEvent(String email, String newPassword);
    void sendModifiedUserEvent(String email, String username, Address address);
    void sendDeletedUserEvent(String email);
}
