package com.prSecurity.service;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DateService {
    public static Date getDate() {
        return new Date();
    }
}