package fr.esir.jxc.controllers;

import com.jxc.dbmanager.models.Article;
import com.jxc.dbmanager.models.User;
import fr.esir.jxc.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/users/")
public class ArticleController {
    @Autowired
    ArticleService articleservice;


    @PostMapping("{email}/articles/{articleId}/share")
    public void shareArticle(@RequestBody PathVariable articleId, PathVariable email ){


    }
}
