package fr.esir.jxc.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean userExists(String email) {
        return true;
    }

    public boolean userOwnsArticle(String email, String articleId) {
        return true;
    }
}