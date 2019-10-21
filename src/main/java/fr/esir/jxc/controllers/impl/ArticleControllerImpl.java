package fr.esir.jxc.controllers.impl;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.controllers.ArticleController;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.services.ArticleService;
import fr.esir.jxc.utils.Patterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ArticleControllerImpl implements ArticleController {
    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseEntity createArticle(ArticleCreationDTO articleCreationDTO) {
        String userEmail = articleCreationDTO.getEmail();
        String articleUrl = articleCreationDTO.getUrl();
        if(userEmail == null || articleUrl == null) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Given user email or article URL are empty.");
        }
        if (!Patterns.EMAIL_PATTERN.matcher(userEmail).matches()){
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : The given email is in the wrong format)");
        }

        articleService.sendCreateArticleEvent(articleCreationDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Create article request received");
    }
}
