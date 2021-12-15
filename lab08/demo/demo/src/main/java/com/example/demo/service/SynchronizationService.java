package com.example.demo.service;

import com.example.demo.quartz.SynchronizationInfo;
import com.example.demo.quartz.TimeUtil;
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
public class SynchronizationService {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SynchronizationService.class));
    private final Scheduler scheduler;

    @Autowired
    public SynchronizationService() throws SchedulerException {
        this.scheduler = new StdSchedulerFactory().getScheduler();
    }

    public Scheduler scheduler(final Class jobClass, final SynchronizationInfo info){
        final JobDetail jobDetail = TimeUtil.buildJobDetail(jobClass,info);
        final Trigger trigger = TimeUtil.buildTrigger(jobClass, info);

        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            LOGGER.severe(e.getMessage() + e);
        }

        return scheduler;
    }

    public List<SynchronizationInfo> getAllRunningTimers(){
        try {
            return scheduler.getJobKeys(GroupMatcher.anyGroup()).stream().map(jobKey -> {
                final JobDetail jobDetail;
                try {
                    jobDetail = scheduler.getJobDetail(jobKey);
                    return (SynchronizationInfo) jobDetail.getJobDataMap().get(jobKey.getName());
                } catch (final SchedulerException e) {
                    LOGGER.severe(e.getMessage() + e);
                    return null;
                }
            }).filter(Objects::nonNull).collect(Collectors.toList());
        } catch (final SchedulerException e) {
            LOGGER.severe(e.getMessage() + e);
            return Collections.emptyList();
        }
    }

    @PostConstruct
    public void init(){
        try {
            scheduler.start();
        } catch (SchedulerException e){
            LOGGER.severe(e.getMessage() + e);
        }
    }

    @PreDestroy
    public void preDestroy(){
        try {
            scheduler.shutdown();
        } catch (SchedulerException e){
            LOGGER.severe(e.getMessage() + e);
        }
    }
}