package io.jokerr.spring.sandbox.demo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializationBean implements ServiceRegistryLookup,InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitializationBean.class);

    private String url;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.trace("initializing method called");
        getURL();
        LOGGER.trace("initalization complete");
    }

    @Override
    public String getURL() {
        // check local cache
        // do service registry lookup
        url = "http://localhost:8080";
        return url;
    }
}
