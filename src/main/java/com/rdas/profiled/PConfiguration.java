package com.rdas.profiled;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by rdas on 04/10/2016.
 */
@Profile("prod")
@Configuration
public class PConfiguration {
    @PostConstruct
    public void init () {
        System.out.println(" \n\n ---- > In Prod Construct \n\n");
    }
}
