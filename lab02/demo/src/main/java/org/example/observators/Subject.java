package org.example.observators;

import java.util.ArrayList;
import java.util.List;

public class Subject {


    List<Subscriber> subscribers = new ArrayList<Subscriber>();

    public void register(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    public void emit(int number){
        for (Subscriber subscriber: subscribers
             ) {
            subscriber.execute(number);
        }
    }
}
