package com.pjwstk.sakila.diagnostics.service.monitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;


@lombok.Value
public class ServiceData {
    String serviceName;
    String serviceHost;
}