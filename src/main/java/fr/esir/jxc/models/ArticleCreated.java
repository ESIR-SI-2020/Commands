package fr.esir.jxc.models;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import lombok.Value;
import java.util.UUID;

@Value
public class ArticleCreated {

    String id;
    String email;
    String url;

    public ArticleCreated(String id, String email, String url) {
        this.id = id;
        this.email = email;
        this.url = url;
    }


    public static ArticleCreated of(ArticleCreationDTO articleCreationDTO) {
        return new ArticleCreated(
                UUID.randomUUID().toString(),
                articleCreationDTO.getEmail(),
                articleCreationDTO.getUrl()
        );
    }

}