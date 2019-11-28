package fr.esir.jxc.controllers;

import fr.esir.jxc.models.ArticleSharedRequest;
import fr.esir.jxc.models.User;
import fr.esir.jxc.models.Validation;
import fr.esir.jxc.services.ArticleService;
import fr.esir.jxc.services.EventService;
import fr.esir.jxc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/users")
public class ArticleController {

    @Autowired ArticleService articleservice;
    @Autowired Validation validate;
    @Autowired UserService userService;
    @Autowired EventService eventService;


    @PostMapping("/{email}/articles/{articleId}/share")
    @ResponseStatus(HttpStatus.CREATED)
    public void shareArticle(@RequestBody List<String> targetEmails,  @PathVariable  long articleId, @PathVariable("email") String ownerEmail ){
            if (validate.verifyUser(ownerEmail) && validate.articleBelongToUser(articleId,ownerEmail) && validate.verifyArticle(articleId)){

                eventService.shareArticle();
            }

    }
}
