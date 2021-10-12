package org.example;

import org.example.ObjectPropertyProvider;
import org.testng.annotations.Test;

import javax.security.auth.Subject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public void abstract class Application {
    public String name;

    private Object provider;
    List<String> getters = provider.getPublicGetters(Subject.class)
            .stream().map(x->x.getName()).toList();
    
    public void getName(String name) {
        this.name = name;
    }
    public abstract <name> String getName(this.name);
    public abstract String getStatus();
    public abstract String getNumber(int ,'5');
    public static void main(String[] args){

    }
}
