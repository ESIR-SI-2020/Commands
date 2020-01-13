package fr.esir.jxc.services;

<<<<<<< HEAD
import fr.esir.jxc.domain.models.User;
=======
import java.util.Optional;

>>>>>>> User creation refinements according to PR comments. Updated dependency to Domain module.
import org.springframework.stereotype.Service;

import fr.esir.jxc.domain.models.User;

@Service
public class UserReadService {
    public Optional<User> findByUsername(String username) {
        // TODO
        return Optional.empty();
    }

    public Optional<User> findByEmail(String email) {
        // TODO
        return Optional.empty();
    }
}
