package fr.esir.jxc.controllers;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/articles")
public interface ArticleController {
    /**
     * @param body the ArticleCreationDTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createArticle(@RequestBody ArticleCreationDTO articleCreationDTO );
    /**
     * @param articleId the id of the article
     */
    @DeleteMapping("/{articleId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteArticle(@PathVariable final String articleId);
}