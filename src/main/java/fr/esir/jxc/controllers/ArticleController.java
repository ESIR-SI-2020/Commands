package fr.esir.jxc.controllers;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.services.ArticleService;
import fr.esir.jxc.utils.CheckEmailFormat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    /**
     * @param body the ArticleCreationDTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createArticle(@RequestBody ArticleCreationDTO articleCreationDTO ){
        String userEmail = articleCreationDTO.getEmail();
        String articleUrl = articleCreationDTO.getUrl();
        if(userEmail == null || articleUrl == null) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Given user email or article URL are empty.");
        }
        if (!CheckEmailFormat.isValid(userEmail)){
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : The given email is in the wrong format)");
        }
        try {
            articleService.sendCreateArticleEvent(articleCreationDTO.getEmail(), articleCreationDTO.getUrl());
        } catch (InterruptedException | ExecutionException e)  {
            throw new ResourceException(HttpStatus.SERVICE_UNAVAILABLE, "Service unavailable : The event could not be sent)");
        }
    }
    /**
     * @param articleId the id of the article
     */
    @DeleteMapping("/{articleId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteArticle(@PathVariable final String articleId){
        //getArticleID ?
        //if not exists
        // 404
        //else
        try {
            articleService.sendDeletedArticleEvent(articleId);
        } catch (InterruptedException | ExecutionException e)  {
            throw new ResourceException(HttpStatus.SERVICE_UNAVAILABLE, "Service unavailable : The event could not be sent)");
        }
    }
}