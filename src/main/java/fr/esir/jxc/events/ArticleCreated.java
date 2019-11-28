package fr.esir.jxc.events;

import lombok.Value;

@Value
public class ArticleCreated {

    String email;
    String url;

    public ArticleCreated(String email, String url) {
        this.email = email;
        this.url = url;
    }


    public static ArticleCreated of(String email, String url) {
        return new ArticleCreated(
                email,
                url
        );
    }

}