package com.pjwstk.sakila.diagnostics.service.monitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Configuration
class Registerer {
    String serviceName;
    String serviceHost;

    public Registerer(@Value("${sakila.diagnostics.service.name}") String serviceName, @Value("${sakila.diagnostics.service.host}") String serviceHost) {
        this.serviceName = serviceName;
        this.serviceHost = serviceHost;
    }


    @PostConstruct
    public void postConstruct() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ServiceData> entity = new HttpEntity<ServiceData>(new ServiceData(serviceName, serviceHost), headers);

        ResponseEntity response = restTemplate.exchange(
                "http://localhost:8083/monitoring/register", HttpMethod.POST, entity, ServiceData.class);
    }

}