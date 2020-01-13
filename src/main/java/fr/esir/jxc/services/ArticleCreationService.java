package fr.esir.jxc.services;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.DTO.UserCreationDTO;
import fr.esir.jxc.exceptions.ResourceException;
import fr.esir.jxc.utils.EmailFormatChecker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import java.security.InvalidParameterException;
@Slf4j
public class ArticleCreationService {
    public static void validateArticleCreationRequest(ArticleCreationDTO articleCreationDTO) throws ResourceException {
        String userEmail = articleCreationDTO.getEmail();
        String articleUrl = articleCreationDTO.getUrl();
        if(userEmail == null || articleUrl == null || !EmailFormatChecker.isEmailValid(userEmail)) {
            log.warn("Invalid article creation request.");
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Given user email or article URL are empty or incorrect.");
        }
    }
}
