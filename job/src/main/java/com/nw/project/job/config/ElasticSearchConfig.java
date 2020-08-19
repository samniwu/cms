package com.nw.project.job.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

/**
 * elasticsearch config
 * @author niwu
 */
@Component
@Slf4j
public class ElasticSearchConfig {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Value("${elasticsearch.index:cms}")
    private String esIndex;

    @Bean
    public void init() {
        log.info("elasticsearch config start");
        boolean indexExist = elasticsearchTemplate.indexExists(esIndex);
        if (!indexExist) {
            log.info("create index {}", esIndex);
            elasticsearchTemplate.createIndex(esIndex);
        }
        log.info("create mapping {}");
    }

}
