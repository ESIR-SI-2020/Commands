package fr.esir.jxc.services;

import fr.esir.jxc.DTO.ArticleCreationDTO;

public interface ArticleService {
    void sendCreateArticleEvent(String email, String url);
}
