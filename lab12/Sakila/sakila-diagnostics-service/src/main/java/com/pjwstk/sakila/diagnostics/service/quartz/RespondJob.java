package com.pjwstk.sakila.diagnostics.service.quartz;

import com.pjwstk.sakila.diagnostics.monitor.ServiceData;
import com.pjwstk.sakila.diagnostics.service.repositories.MonitoringRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RespondJob implements Job {

    @Autowired
    private MonitoringRepository repo;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        //TODO quartz
//        List<ServiceData> services = repo.getServices();
//        services.forEach(service -> checkService(service));
    }

    private void checkService(ServiceData service) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(service.getServiceHost() + "/diagnostics/status", String.class);
        if(response.getStatusCodeValue() == 200) {
            System.out.println(service.getServiceName() + " working");
        } else {
            System.out.println(service.getServiceName() + " not working");
        }
    }
}
