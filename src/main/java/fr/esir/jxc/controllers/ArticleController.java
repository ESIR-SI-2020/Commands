package fr.esir.jxc.controllers;

import com.jxc.dbmanager.models.Article;
import com.jxc.dbmanager.models.User;
import fr.esir.jxc.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/users/")
public class ArticleController {
    @Autowired
    ArticleService articleservice;


    @PostMapping("{email}/articles/{articleId}/share")
    @ResponseStatus(HttpStatus.CREATED)
    public void shareArticle(@RequestBody List<String> targetEmail,  @PathVariable  long articleId, @PathVariable("email") String ownerEmail ){
        //

    }
}
