package com.example.config;

import com.example.template.HotsTemplate;
import com.example.template.PostsTemplate;
import com.example.template.TimeAgoMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreemarkerConfig {

    @Autowired
    PostsTemplate postsTemplate;
    @Autowired
    HotsTemplate hotsTemplate;
    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("timeAgo", new TimeAgoMethod());
        configuration.setSharedVariable("posts", postsTemplate);
        configuration.setSharedVariable("hots", hotsTemplate);


    }

}
