package fr.esir.jxc.event;

import lombok.Value;
import java.util.UUID;

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