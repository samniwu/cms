package com.nw.project.job.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
public class ElasticSearchConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchConfig.class);
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Value("${elasticsearch.index:cms}")
    private String esIndex;

    @Bean
    public void elasticSearchConfig() {
        LOGGER.info("elasticsearch config start,index:{}",esIndex);
        boolean indexExist = elasticsearchTemplate.indexExists(esIndex);
        if (!indexExist) {
            LOGGER.info("create index {}", esIndex);
            elasticsearchTemplate.createIndex(esIndex);
        }
        LOGGER.info("create mapping {}");
    }

}
