package fr.esir.jxc.controllers;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/articles")
public interface ArticleController {
    /**
     * @param body the ArticleCreationDTO
     */
    @PostMapping
    public ResponseEntity createArticle(@RequestBody ArticleCreationDTO articleCreationDTO );
}