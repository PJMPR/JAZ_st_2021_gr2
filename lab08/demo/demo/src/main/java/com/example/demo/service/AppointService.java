package com.example.demo.service;

import com.example.demo.quartz.ScheduleInfo;
import com.example.demo.quartz.TimerUtil;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AppointService {
    private final Scheduler scheduler;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SchedulerService.class));
    
    @Autowired
    public SchedulerService() throws SchedulerException {
        this.scheduler = new StdSchedulerFactory().getScheduler();
    }

    public Scheduler schedule(final Class jobClass, final ScheduleInfo info){
        final Trigger trigger = TimerUtil.buildTrigger(jobClass, info);
        final JobDetail jobDetail = TimerUtil.buildJobDetail(jobClass, info);

        try{
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOGGER.severe( e.getMessage() + e);
        }
        return scheduler;
    }

    @PostConstruct
    public void init(){
        try {
            scheduler.start();
        }catch (SchedulerException e){
            LOGGER.severe(e.getMessage() + e);
        }
    }

    @PreDestroy
    public void preDestroy(){
        try {
            scheduler.shutdown();
        }catch (SchedulerException e){
            LOGGER.severe(e.getMessage() + e);
        }
    }

    public List<ScheduleInfo> getAllRunningTimers() {
        try {
            return scheduler.getJobKeys(GroupMatcher.anyGroup())
                    .stream()
                    .map(jobKey -> {
                        try {
                            final JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                            return (ScheduleInfo) jobDetail.getJobDataMap().get(jobKey.getName());
                        } catch (final SchedulerException e) {
                            LOGGER.severe(e.getMessage() + e);
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (final SchedulerException e) {
            LOGGER.severe(e.getMessage() + e);
            return Collections.emptyList();
        }
    }
    
}