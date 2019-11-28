package fr.esir.jxc;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.controllers.impl.ArticleControllerImpl;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.services.ArticleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestArticleController {
    @InjectMocks
    private ArticleControllerImpl articleController;

    @Mock
    private ArticleService articleService;

    @BeforeAll
    public void setup() {
        //Mockito.doNothing().when(articleService).sendCreateArticleEvent(isA(ArticleCreationDTO.class));
    }

    @Test
    public void createArticle_ShouldReturnOK_OK() {
        ResponseEntity response = articleController.createArticle(new ArticleCreationDTO("test@orange.fr", "/uid"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test(expected = ResourceException.class)
    public void createArticle_WithBadEmail_ShouldReturnNOK_400() {
        ResponseEntity response = articleController.createArticle(new ArticleCreationDTO("t.fr", "/uid"));
    }
}