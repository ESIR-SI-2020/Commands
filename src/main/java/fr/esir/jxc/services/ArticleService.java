package fr.esir.jxc.services;

import fr.esir.jxc.events.ArticleShared;
import fr.esir.jxc.models.ArticleSharedRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService extends ElasticsearchRepository {

    ArticleSharedRequest findById(Long articleid);
}
