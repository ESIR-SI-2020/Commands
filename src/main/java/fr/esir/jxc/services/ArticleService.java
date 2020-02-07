package fr.esir.jxc.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArticleService {
    public boolean articleExists(String id) {
        return Arrays.stream(new String[]{"article1", "article2", "article3"}).anyMatch(id::equals);
    }
}