package fr.esir.jxc.models;

import fr.esir.jxc.events.ArticleShared;
import fr.esir.jxc.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Validation {

    @Autowired ArticleService articleService;

    //verify email
    public Boolean verifyEmail(String email){
        return true;
    }
    // verify user
    public  Boolean verifyUser(String email){
        if(true)// format of email
        {
           return true;
        }
        return true;
    }
    //Article exists or not
    public Boolean verifyArticle(Long articleid){

        ArticleSharedRequest article = articleService.findById(articleid);
        if(article==null){
            return false;
        }
        return true;
    }

    //Article belongs to the user who wants to share
    public Boolean articleBelongToUser(Long articleid, String Email ){
        return true;
    }
}
