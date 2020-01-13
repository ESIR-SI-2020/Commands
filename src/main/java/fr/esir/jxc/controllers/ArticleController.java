package fr.esir.jxc.controllers;

import fr.esir.jxc.models.ShareArticleRequest;
import fr.esir.jxc.services.ArticleService;
import fr.esir.jxc.services.ShareArticleService;
import fr.esir.jxc.services.UserService;
import fr.esir.jxc.utils.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/v1/users")
public class ArticleController {

    @Autowired private ShareArticleService shareArticleService;
    @Autowired private UserService userService;
    @Autowired private ArticleService articleService;

    @PostMapping("/{email}/articles/{articleId}/share")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void shareArticle(@RequestBody ShareArticleRequest targetEmails, @PathVariable  String articleId, @PathVariable(value = "email") String ownerEmail ){
        boolean validOwnerEmail = Format.validateEmail(ownerEmail);
        boolean validTargetEmails = targetEmails.getTargetEmails().stream().allMatch(Format::validateEmail);
        if (!validOwnerEmail
            || !validTargetEmails
            || !userService.userExists(ownerEmail)
            || !articleService.articleExists(articleId)
            || !userService.userOwnsArticle(ownerEmail, articleId))
        {
            throw new InvalidParameterException();
        }

        // TODO
        // implement actual validation for request data (article & users must exist, article must be owned by sharing user)

        shareArticleService.shareArticle(articleId, ownerEmail, targetEmails);
    }
}
