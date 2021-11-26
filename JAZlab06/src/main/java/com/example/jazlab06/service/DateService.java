package com.example.jazlab06.service;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DateService{
    public  Date getDate(){
        return new Date();
    }
}