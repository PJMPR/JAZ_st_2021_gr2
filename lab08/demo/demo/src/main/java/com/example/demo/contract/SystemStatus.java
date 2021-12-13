package com.example.demo.contract;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class SystemStatus {
    boolean isWorking;
    Date reloadStarted;
    Date reloadEnded;
    int updateMovies;
    int howMuchDone;
    ArrayList<ProcessStatus> stepsFinished;
    
    public boolean getWorking() {
        return isWorking;
    }
    
    public void setIsWorking(boolean working) {
        isWorking = working;
    }

    public Date getReloadStarted() {
        return reloadStarted;
    }

    public void setReloadStarted(Date reloadStarted) {
        this.reloadStarted = reloadStarted;
    }

    public Date getReloadEnded() {
        return reloadEnded;
    }

    public void setReloadEnded(Date reloadEnded) {
        this.reloadEnded = reloadEnded;
    }

    public int getMoviesUpdate() {
        return updateMovies;
    }

    public void setMoviesUpdate(int moviesUpdate) {
        this.updateMovies = moviesUpdate;
    }

    public int getHowMuchDone() {
        return howMuchDone;
    }

    public void setHowMuchDone0(int howMuchDone) {
        this.howMuchDone = howMuchDone;
    }

    public ArrayList<ProcessStatus> getStepsFinished() {
        return stepsFinished;
    }

    public void setStepsFinished(ArrayList<ProcessStatus> stepsFinished) {
        this.stepsFinished = stepsFinished;
    }
    
}