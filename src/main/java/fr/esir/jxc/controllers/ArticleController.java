package fr.esir.jxc.controllers;

import fr.esir.jxc.services.ArticleCreationService;
import fr.esir.jxc.services.ArticleReadService;
import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.services.ArticleWriteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping(value = "/articles")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleWriteService articleWriteService;
    @Autowired
    private ArticleReadService articleReadService;

    /**
     * @param body the ArticleCreationDTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createArticle(@RequestBody ArticleCreationDTO articleCreationRequest){
        ArticleCreationService.validateArticleCreationRequest(articleCreationRequest);

        if (this.articleReadService.findByUrl(articleCreationRequest.getUrl()).isPresent()) {
            log.warn("Article already existing for url {0}.", articleCreationRequest.getUrl());
            throw new ResourceException(HttpStatus.CONFLICT, "Found : The given article already exists");
        }

        articleWriteService.create(articleCreationRequest.getEmail(), articleCreationRequest.getUrl());
    }

    /**
     * @param articleId the id of the article
     */
    @DeleteMapping("/{articleId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteArticle(@PathVariable final String articleId){
        if (articleId == null || !this.articleReadService.findById(articleId).isPresent()) {
            log.warn("Article not existing for id {0}.", articleId);
            throw new ResourceException(HttpStatus.NOT_FOUND, "Not found : The given article doesn't exists");
        }

        articleWriteService.delete(articleId);
    }
}