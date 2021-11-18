package org.example.Actions;


import org.apache.log4j.Logger;
import org.example.Supplier.Supplier;

public class ExceptionActions{

    public void wait(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean repeat(Supplier method, int times) {
        if (times > 0) {
            System.out.println("Trying again, attempts left: " + times);
            try {
                method.execute();
                return true;
            } catch (Exception exc) {
                    wait(3);
                    repeat(method, times-1);
                }
            }
        return false;
    }

}
