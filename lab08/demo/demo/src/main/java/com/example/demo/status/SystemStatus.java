package com.example.demo.status;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;

@Component
@Getter
@Setter
@NoArgsConstructor
public class SystemStatus {
    boolean isWorking;
    Date reloadStarted;
    Date reloadEnded;
    int moviesToUpdate;
    int progress;
    ArrayList<ProcessStatus> stepsFinished;

    public boolean isWorking() {
        return isWorking;
    }
}