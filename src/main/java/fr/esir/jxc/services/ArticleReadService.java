package fr.esir.jxc.services;

import fr.esir.jxc.domain.models.Article;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleReadService {
    public Optional<Article> findByUrl(String url) {
        // TODO
        return Optional.empty();
    }

    public Optional<Article> findById(String id) {
        // TODO
        return Optional.empty();
    }
}
