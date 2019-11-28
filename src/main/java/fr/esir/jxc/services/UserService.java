package fr.esir.jxc.services;

import fr.esir.jxc.models.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserService extends ElasticsearchRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
}
